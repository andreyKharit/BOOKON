/*
 * Last updated: 5/4/20, 8:27 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.entities.Author;
import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Genre;
import com.itacademy.ankhar.entities.Publisher;
import com.itacademy.ankhar.interfaces.IBookCreatorService;
import com.itacademy.ankhar.repositories.AuthorRepository;
import com.itacademy.ankhar.repositories.BookRepository;
import com.itacademy.ankhar.repositories.PublisherRepository;
import com.itacademy.ankhar.util.libraryDBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementationBookCreatorService implements IBookCreatorService {

    //spring
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private libraryDBUtil libraryDBUtil;

    @Override
    public boolean createBookEntry(String bookName, String authorName, String publisherName, String... genres) throws Exception {
        //stops if entity is duplicate
        Book newBook = bookRepository.findByName(bookName).orElseGet(null);
        if (newBook == null) return false;
        //adding existing author if needed
        Author author = authorRepository.findByNameIgnoreCase(authorName).orElseGet(Author::new);
        author.addBooks(newBook);
        //adding existing publisher if needed
        Publisher publisher = publisherRepository.findByPublisherNameIgnoreCase(publisherName).orElseGet(Publisher::new);
        //genres check
        List<Genre> genreList = libraryDBUtil.genreListPackager(genres);
        newBook.setGenres(genreList);
        //done
        bookRepository.save(newBook);
        return true;
    }
}
