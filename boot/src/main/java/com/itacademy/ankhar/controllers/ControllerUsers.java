/*
 * Last updated: 6/20/20, 1:36 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import com.itacademy.ankhar.interfaces.IAuthorizationService;
import com.itacademy.ankhar.interfaces.IRegistrationService;
import com.itacademy.ankhar.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class ControllerUsers {
    @Autowired
    private ISubjectService subjectService;
    @Autowired
    private IRegistrationService registrationService;

    @RequestMapping("")
    public ModelAndView userList(ModelAndView modelAndView) {
        modelAndView.addObject("users", subjectService.getSubjects());
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(path = {"/edit/{id}"})
    public ModelAndView editUserById(ModelAndView modelAndView, @PathVariable Long id)
            throws Exception {
        if (id != null) {
            modelAndView.addObject("editUser", subjectService.getSubjectById(id));
            modelAndView.setViewName("user-editor");
            return modelAndView;
        } else {
            modelAndView.setViewName("user-list");
            return modelAndView;
        }
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteUserById(@PathVariable Long id)
            throws Exception {
        subjectService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(path = "/edit/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam("id") Long id, @RequestParam("status") String status) throws Exception {
        subjectService.updateUserStatus(id, status);
        return "redirect:/users";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView createUser(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(path = "/create-user", method = RequestMethod.POST)
    public String createUser(String name, String password) throws Exception {
        registrationService.createUser(name, BCrypt.hashpw(password, BCrypt.gensalt(11)));
        return "redirect:/users";
    }
}
