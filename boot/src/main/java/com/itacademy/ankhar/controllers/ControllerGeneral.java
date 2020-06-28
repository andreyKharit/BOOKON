/*
 * Last updated: 6/25/20, 8:57 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ControllerGeneral {
    @Autowired
    IAuthorizationService authorizationService;

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

    @RequestMapping(path = "/login-user", method = RequestMethod.POST)
    public String loginUser(String name, String password) throws Exception {
        if (BCrypt.checkpw(password, authorizationService.authorize(name))) {
            return "redirect:/users";
        } else {
            return "redirect:/error/403";
        }
    }
}
