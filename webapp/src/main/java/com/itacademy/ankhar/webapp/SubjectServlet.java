/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.impl.ImplementationSubjectService;
import com.itacademy.ankhar.interfaces.ISubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectServlet", urlPatterns = {"/subjects"})
public class SubjectServlet extends HttpServlet {
    private ISubjectService subjectService = ImplementationSubjectService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> subjects = subjectService.getSubjects();
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("subjects.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delete = req.getParameter("delete");
        String edit = req.getParameter("status");
        String hiddenId = req.getParameter("hiddenId");
        if (delete != null) {
            try {
                subjectService.deleteUser(Long.valueOf(delete));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (edit != null && hiddenId != null) {
            try {
                subjectService.updateUserStatus(Long.valueOf(hiddenId), edit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect(req.getContextPath() + "/subjects");
    }
}
