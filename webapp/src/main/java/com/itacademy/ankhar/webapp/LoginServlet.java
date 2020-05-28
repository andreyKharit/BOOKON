/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.impl.ImplementationAuthorizationService;
import com.itacademy.ankhar.interfaces.IAuthorizationService;
import com.itacademy.ankhar.util.UserDBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"})
@Component
public class LoginServlet extends HttpServlet {
    @Autowired
    private IAuthorizationService auth;
    private final UserDBUtil utils = UserDBUtil.getInstance();

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
        boolean userId = auth.authorize(username, password);
        req.setAttribute("username", username);
        if (userId) {
//                resp.sendRedirect(req.getContextPath() + "/main-menu.jsp");
            req.getSession().setAttribute("authorized", true);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("status", utils.getStatus(username));
            req.getSession().setAttribute("currentMessage", "");
            req.getRequestDispatcher("/main-menu.jsp").forward(req, resp);
        } else {
//                req.setAttribute("error", "Wrong username or password.");
            req.getSession().setAttribute("currentMessage", "Wrong username or password.");
            resp.sendRedirect(req.getContextPath() + "/error401.jsp");
        }
    }
}