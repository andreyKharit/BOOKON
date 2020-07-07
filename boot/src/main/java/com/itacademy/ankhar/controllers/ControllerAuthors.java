/*
 * Last updated: 7/6/20, 6:24 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authors")
public class ControllerAuthors {
    @Autowired
    ILibraryService libraryService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView listAuthors(ModelAndView modelAndView) {
        modelAndView.addObject("authors", libraryService.getAuthors());
        modelAndView.setViewName("author-list");
        return modelAndView;
    }

    @RequestMapping(path = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewAuthor(ModelAndView modelAndView, @PathVariable("id") Long id) {
        if (id != null) {
            modelAndView.addObject("authorView", libraryService.getAuthorById(id));
            modelAndView.setViewName("author-view");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(path = "/create")
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public ModelAndView createFormView(ModelAndView modelAndView) {
        modelAndView.setViewName("author-create");
        return modelAndView;
    }

    @RequestMapping(path = "/create-author", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String createAuthor(@RequestParam("name") String name) {
        if (!name.isEmpty()) {
            libraryService.updateAuthor(name);
        }
        return "redirect:/authors";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public ModelAndView editAuthor(ModelAndView modelAndView, @PathVariable("id") Long id) {
        if (id != null) {
            modelAndView.addObject("authorView", libraryService.getAuthorById(id));
            modelAndView.setViewName("author-edit");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(path = "/update-author", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String updateAuthor(@RequestParam("id") Long id, @RequestParam("name") String name) {
        if (id != null && name != null) {
            libraryService.updateAuthor(id, name);
        }
        return "redirect:/authors";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String deleteAuthor(@PathVariable("id") Long id) {
        if (id != null) libraryService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
