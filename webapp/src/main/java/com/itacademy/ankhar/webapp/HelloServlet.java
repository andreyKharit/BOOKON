/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String requestPath = req.getContextPath();
        String requestURI = req.getRequestURI();
        writer.write("<h1>Servlet:</h1>");
        writer.write("<p>" + requestPath + "</p>");
        writer.write("<p>" + requestURI + "</p>");
        writer.write("<a href=\\webapp/s>goodbye</a>");
    }
}
