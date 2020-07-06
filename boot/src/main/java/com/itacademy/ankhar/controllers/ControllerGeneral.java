/*
 * Last updated: 6/25/20, 8:57 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.IAuthorizationService;
import com.itacademy.ankhar.interfaces.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControllerGeneral {
    @Autowired
    IAuthorizationService authorizationService;
    @Autowired
    private IRegistrationService registrationService;

    @GetMapping({"/", "/index"})
    public String getHomePage(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/logout-success")
    public String getLogoutPage(Model model) {
        return "logout";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView createUser(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(path = "/create-user", method = RequestMethod.POST)
    public String createUser(String name, String password) throws Exception {
        registrationService.createUser(name, BCrypt.hashpw(password, BCrypt.gensalt(11)));
        return "redirect:/index";
    }
}
