/*
 * Last updated: 7/7/20, 7:14 AM
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
@RequestMapping("/publishers")
public class ControllerPublisher {
    @Autowired
    ILibraryService libraryService;

    @RequestMapping("")
    public ModelAndView publisherList(ModelAndView modelAndView) {
        modelAndView.addObject("publishers", libraryService.getPublishers());
        modelAndView.setViewName("publisher-list");
        return modelAndView;
    }

    @RequestMapping(path = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewPublisher(ModelAndView modelAndView, @PathVariable("id") Long id) {
        if (id != null) {
            modelAndView.addObject("publisherView", libraryService.getPublisherById(id));
            modelAndView.setViewName("publisher-view");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(path = "/create")
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public ModelAndView createFormView(ModelAndView modelAndView) {
        modelAndView.setViewName("publisher-create");
        return modelAndView;
    }

    @RequestMapping(path = "/create-publisher", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String createPublisher(@RequestParam("name") String name) {
        if (!name.isEmpty()) {
            libraryService.updatePublisher(name);
        }
        return "redirect:/publishers";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public ModelAndView editAuthor(ModelAndView modelAndView, @PathVariable("id") Long id) {
        if (id != null) {
            modelAndView.addObject("publisherView", libraryService.getPublisherById(id));
            modelAndView.setViewName("publisher-edit");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(path = "/update-publisher", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String updatePublisher(@RequestParam("id") Long id, @RequestParam("name") String name) {
        if (id != null && name != null) {
            libraryService.updatePublisher(id, name);
        }
        return "redirect:/publishers";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
    public String deletePublisher(@PathVariable("id") Long id) {
        if (id != null) libraryService.deletePublisher(id);
        return "redirect:/publishers";
    }
}
