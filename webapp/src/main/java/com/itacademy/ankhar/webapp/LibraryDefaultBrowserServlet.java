/*
 * Last updated: 5/10/20, 3:28 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.impl.ImplementationDefaultLibraryService;
import com.itacademy.ankhar.interfaces.ILibraryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LibraryDefaultBrowserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ILibraryService libraryService = ImplementationDefaultLibraryService.getInstance();
        List<Book> bookList = libraryService.getBooks();
        for (Book book : bookList) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
