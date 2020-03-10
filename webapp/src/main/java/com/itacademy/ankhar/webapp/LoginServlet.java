/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.impl.AuthorizationServiceImplementation;
import com.itacademy.ankhar.interfaces.AuthorizationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private AuthorizationService auth = new AuthorizationServiceImplementation();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Long userId = auth.authorize(username, password);
        req.setAttribute("username", username);
        if (userId != null) {
            if (userId == 1L) {
//                resp.sendRedirect(req.getContextPath() + "/main-menu.jsp");
                req.getSession().setAttribute("authorized", true);
                req.getRequestDispatcher( "/main-menu.jsp").forward(req, resp);
            } else {
//                req.setAttribute("error", "Wrong username or password.");
                resp.sendRedirect(req.getContextPath() + "/error401.jsp");
            }
        }
    }
}