/*
 * Last updated: 6/20/20, 1:36 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class ControllerUsers {
    @Autowired
    private ISubjectService subjectService;

    @RequestMapping("/list")
    public ModelAndView userList(ModelAndView modelAndView) {
        modelAndView.addObject("users", subjectService.getSubjects());
        return modelAndView;
    }
}
