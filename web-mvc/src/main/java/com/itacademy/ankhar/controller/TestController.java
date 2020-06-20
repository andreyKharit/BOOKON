/*
 * Last updated: 6/9/20, 7:32 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage(ModelAndView modelAndView) {
        final Set<String> usernames = new HashSet<>();
        usernames.add("Bob");
        usernames.add("Pete");
        usernames.add("John");
        modelAndView.addObject("username", usernames);
        return modelAndView;
    }
}
