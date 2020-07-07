/*
 * Last updated: 7/7/20, 8:12 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/requests")
@PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_WORKER'})")
public class ControllerRequest {
    @Autowired
    ISubjectService subjectService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView listRequests(ModelAndView modelAndView) {
        modelAndView.addObject("requests", subjectService.getAllRequests());
        modelAndView.setViewName("request-list");
        return modelAndView;
    }

    @RequestMapping(path = "/close/{id}")
    public String closeRequest(@PathVariable("id") Long id) {
        if (id!= null) subjectService.deleteRequest(id);
        return "redirect:/requests";
    }
}
