/*
 * Last updated: 4/22/20, 4:53 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.Genre;
import com.itacademy.ankhar.Publisher;
import com.itacademy.ankhar.interfaces.ILibraryService;

import java.util.List;

public class ImplementationDefaultLibraryService implements ILibraryService {
    private static ILibraryService libraryService;

    private ImplementationDefaultLibraryService() {
    }

    public static ILibraryService getInstance() {
        if (libraryService == null) {
            synchronized (ImplementationDefaultLibraryService.class) {
                if (libraryService == null) {
                    libraryService = new ImplementationDefaultLibraryService();
                }
            }
        }
        return libraryService;
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public List<Publisher> getPublishers() {
        return null;
    }

    @Override
    public List<Genre> getGenres() {
        return null;
    }
}
