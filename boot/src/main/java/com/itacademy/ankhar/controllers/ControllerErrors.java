/*
 * Last updated: 6/28/20, 6:50 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ControllerErrors {
    @GetMapping("403")
    public ModelAndView error403(ModelAndView modelAndView) {
        modelAndView.setViewName("errors/403");
        return modelAndView;
    }
}
