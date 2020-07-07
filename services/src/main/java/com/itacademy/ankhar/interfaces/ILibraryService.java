/*
 * Last updated: 4/22/20, 4:53 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

import com.itacademy.ankhar.entities.Author;
import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Genre;
import com.itacademy.ankhar.entities.Publisher;

import java.util.List;

public interface ILibraryService {
    List<Book> getBooks();
    List<Book> getBooksByPage(int page);
    void updateBook(Long id, String title, List<Long> genres, Integer status, String publisher, String author);
    void deleteBook(Long id);
    int getBooksPages(int page);
    Book getBookById(Long id);
    List<Publisher> getPublishers();
    Publisher getPublisherById(Long id);
    void updatePublisher(Long id, String name);
    void updatePublisher(String name);
    void deletePublisher(Long id);
    List<Genre> getGenres();
    List<Author> getAuthors();
    Author getAuthorById(Long id);
    void updateAuthor(Long id, String name);
    void updateAuthor(String name);
    void deleteAuthor(Long id);
}
