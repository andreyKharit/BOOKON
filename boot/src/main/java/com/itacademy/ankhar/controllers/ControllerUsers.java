/*
 * Last updated: 6/20/20, 1:36 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class ControllerUsers {
    @Autowired
    private ISubjectService subjectService;

    @RequestMapping("")
    public ModelAndView userList(ModelAndView modelAndView) {
        modelAndView.addObject("users", subjectService.getSubjects());
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(path = {"/edit/{id}"})
    public ModelAndView editUserById(ModelAndView modelAndView, @PathVariable Long id)
            throws HttpClientErrorException.NotFound {
        if (id != null) {
            modelAndView.addObject("user", subjectService.getSubjectById(id));
            modelAndView.setViewName("user-editor");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/users");
            return modelAndView;
        }
    }

    @RequestMapping(path = "/delete/{id}")
    public ModelAndView deleteUserById(ModelAndView modelAndView, @PathVariable Long id)
            throws Exception {
        subjectService.deleteUser(id);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(ModelAndView modelAndView, Long id, String status) throws Exception {
        subjectService.updateUserStatus(id, status);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }
}
