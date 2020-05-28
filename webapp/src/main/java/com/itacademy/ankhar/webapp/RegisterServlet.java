/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.impl.ImplementationRegistrationService;
import com.itacademy.ankhar.interfaces.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "RegistrationServlet",
        urlPatterns = {"/registration"})
@Component
public class RegisterServlet extends HttpServlet {
    @Autowired
    private IRegistrationService registrationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            if (registrationService.createUser(username, password)) {
                req.getSession().setAttribute("currentMessage", "New user created!");
            } else {
                req.getSession().setAttribute("currentMessage", "Username already exists, please change yours.");
            }
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        } catch (Exception e) {
            req.getSession().setAttribute("currentMessage", "Unexpected error.");
            resp.sendRedirect(req.getContextPath() + "/error401.jsp");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
