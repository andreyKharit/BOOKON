/*
 * Last updated: 7/3/20, 8:48 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Random;

@Controller
public class AjaxJQuerryTest {
    @RequestMapping("/ajax")
    public ModelAndView ajaxTest() {
        return new ModelAndView("ajax","message","Ajax testing...");
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody String getTime(){
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from AjaxTest Controller.." + new Date().toString());
        return result;
    }
}
