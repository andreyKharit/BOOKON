/*
 * Last updated: 4/22/20, 4:53 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.Genre;
import com.itacademy.ankhar.Publisher;

import java.util.List;

public interface ILibraryService {
    List<Book> getBooks();
    List<Publisher> getPublishers();
    List<Genre> getGenres();
}
