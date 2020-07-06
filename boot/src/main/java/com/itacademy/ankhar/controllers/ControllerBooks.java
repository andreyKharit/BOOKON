/*
 * Last updated: 6/29/20, 7:38 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.entities.Author;
import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Genre;
import com.itacademy.ankhar.entities.Publisher;
import com.itacademy.ankhar.interfaces.ILibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/books")
public class ControllerBooks {
    @Autowired
    ILibraryService libraryService;

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

    @RequestMapping(path = "/view/{id}")
    public ModelAndView bookView(ModelAndView modelAndView, @PathVariable("id") Long id) {
        if (id != null) {
            modelAndView.addObject("viewBook", libraryService.getBookById(id));
            modelAndView.addObject("allGenres", libraryService.getGenres());
            modelAndView.setViewName("book-view");
            return modelAndView;
        } else {
            modelAndView.setViewName("book-list");
            return modelAndView;
        }
    }

    @RequestMapping(path = "/update-book", method = {RequestMethod.POST})
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
}
