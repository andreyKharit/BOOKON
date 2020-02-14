package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.Subject;
import com.itacademy.ankhar.impl.SubjectServiceImplementation;
import com.itacademy.ankhar.interfaces.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "subjectServlet", urlPatterns = {"/subjects"})
public class SubjectServlet extends HttpServlet {
    private SubjectService subjectService = SubjectServiceImplementation.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjects = subjectService.getSubjects();
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("/subjects.jsp").forward(req, resp);
    }
}
