/*
 * Last updated: 6/15/20, 1:57 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class ControllerTest {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView modelAndView(ModelAndView modelAndView) {
        final List<User> userList = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);
        return modelAndView.addObject("users", userList);
    }
}
