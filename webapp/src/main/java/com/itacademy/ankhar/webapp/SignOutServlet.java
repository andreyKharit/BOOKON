package com.itacademy.ankhar.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "LogOutServlet",
        urlPatterns = {"/logout"}
)
public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(false);
        if (currentSession != null) {
            currentSession.invalidate();
        }
        req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
    }
}