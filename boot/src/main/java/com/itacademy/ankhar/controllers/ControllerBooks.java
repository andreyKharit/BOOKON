/*
 * Last updated: 6/29/20, 7:38 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.ILibraryService;
import com.itacademy.ankhar.interfaces.ISubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/books")
public class ControllerBooks {
    @Autowired
    ILibraryService libraryService;
    @Autowired
    ISubjectService subjectService;

    Logger logger = LoggerFactory.getLogger(ControllerBooks.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView bookList(ModelAndView modelAndView,
                                 @RequestParam("page") Optional<Integer> currentPage) {
        int page = currentPage.orElse(1);
        modelAndView.addObject("currentBookPage", page);
        modelAndView.addObject("books", libraryService.getBooksByPage(page - 1));
        int totalPages = libraryService.getBooksPages(page - 1);
        modelAndView.addObject("bookTotalPages", totalPages);
        if (totalPages > 0) {
            List<Integer> pageNumbers =
                    IntStream.rangeClosed(1, totalPages)
                            .boxed()
                            .collect(Collectors.toList());
            modelAndView.addObject("bookPageNumbers", pageNumbers);
        }
        modelAndView.setViewName("book-list");
        return modelAndView;
    }

    @GetMapping(path = "/create")
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public ModelAndView createView(ModelAndView modelAndView) {
        modelAndView.setViewName("book-create");
        return modelAndView;
    }

    @RequestMapping(path = "/view/{id}")
    public ModelAndView bookView(ModelAndView modelAndView, @PathVariable("id") Long id) {
        if (id != null) {
            modelAndView.addObject("viewBook", libraryService.getBookById(id));
            modelAndView.addObject("allGenres", libraryService.getGenres());
            modelAndView.setViewName("book-view");
        } else {
            modelAndView.setViewName("book-list");
        }
        return modelAndView;
    }

    @RequestMapping(path = "/update-book", method = {RequestMethod.POST})
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String updateBook(@RequestParam("bookGenre") Optional<List<Long>> genres,
                             @RequestParam("id") Long id,
                             @RequestParam("publisherName") String publisher,
                             @RequestParam("authorName") String author,
                             @RequestParam("bookStatus") Optional<String> status,
                             @RequestParam("bookTitle") String title) {

        logger.info("Book update started, book name: " + title);
        Integer statusBk = (status.isPresent() ? 1 : 0);
        logger.info("Active genres ids (if present):");
        genres.ifPresent(longs -> longs.forEach(g -> logger.info(g.toString())));
        List<Long> listGenres = genres.orElse(null);
        libraryService.updateBook(id, title, listGenres,
                statusBk, publisher, author);
        logger.info("Done.");
        return "redirect:/books";
    }

    @RequestMapping(path = "/create-book", method = {RequestMethod.POST})
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String updateBook(@RequestParam("bookGenre") Optional<List<Long>> genres,
                             @RequestParam("publisherName") String publisher,
                             @RequestParam("authorName") String author,
                             @RequestParam("bookTitle") String title) {

        logger.info("Book creation started, book name: " + title);
        logger.info("Active genres ids (if present):");
        genres.ifPresent(longs -> longs.forEach(g -> logger.info(g.toString())));
        List<Long> listGenres = genres.orElse(null);
        libraryService.updateBook(null, title, listGenres,
                1, publisher, author);
        logger.info("Done.");
        return "redirect:/books";
    }

    @RequestMapping(path = "/delete/{id}")
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String deleteBook(@PathVariable("id") Long id) {
        libraryService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(path = "/request-book", method = RequestMethod.POST)
    @PreAuthorize("hasRole({'ROLE_USER'})")
    public String createRequest(Principal principal, @RequestParam("id") Long bookId, @RequestParam("comment") String status) {
        Calendar calendar = new GregorianCalendar(Locale.getDefault());
        subjectService.saveRequest(null, bookId, principal.getName(),
                "[" + calendar.getTime().toString() + "] " + status);
        return "redirect:/books";
    }
}
