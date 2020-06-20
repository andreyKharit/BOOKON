/*
 * Last updated: 4/22/20, 4:53 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Genre;
import com.itacademy.ankhar.entities.Publisher;

import java.util.List;

public interface ILibraryService {
    List<Book> getBooks();
    List<Publisher> getPublishers();
    List<Genre> getGenres();
}
