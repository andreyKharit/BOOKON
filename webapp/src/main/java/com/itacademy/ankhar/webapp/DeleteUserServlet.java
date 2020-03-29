/*
 * Copyright (c) 2020
 * Last updated: 3/29/20, 5:04 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.impl.SubjectServiceImplementation;
import com.itacademy.ankhar.interfaces.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "DeleteUser",
        urlPatterns = {"/delete"}
)
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("delete") != null) {
            Long id = Long.parseLong(req.getParameter("delete"));
            SubjectService subjectService = SubjectServiceImplementation.getInstance();
            try {
                subjectService.deleteUser(id);
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/error401.jsp");
            }
        }
    }
}
