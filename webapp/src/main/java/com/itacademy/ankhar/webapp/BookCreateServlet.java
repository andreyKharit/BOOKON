/*
 * Last updated: 5/4/20, 8:17 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.impl.ImplementationBookCreatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(
        name = "BookCreatorServlet",
        urlPatterns = {"/create_book"}
)
public class BookCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("book");
        String authorName = req.getParameter("author");
        String publisherName = req.getParameter("publisher");
        String[] genreArray = req.getParameterValues("genres");
        List<String> genreList = Arrays.asList(genreArray);

        ImplementationBookCreatorService service = new ImplementationBookCreatorService();
        try {
            service.createBookEntry(bookName, authorName, publisherName, genreList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
