/*
 * Last updated: 4/22/20, 4:53 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.entities.Author;
import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Genre;
import com.itacademy.ankhar.entities.Publisher;
import com.itacademy.ankhar.interfaces.ILibraryService;
import com.itacademy.ankhar.repositories.AuthorRepository;
import com.itacademy.ankhar.repositories.BookRepository;
import com.itacademy.ankhar.repositories.GenreRepository;
import com.itacademy.ankhar.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ImplementationDefaultLibraryService implements ILibraryService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> getBooks() {
        final List<Book> books = new LinkedList<>();
        bookRepository.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public List<Book> getBooksByPage(int page) {
        final List<Book> books = new LinkedList<>();
        bookRepository.findAll(PageRequest.of(page, 6)).iterator()
                .forEachRemaining(books::add);
        return books;
    }

    @Override
    public int getBooksPages(int page) {
        return bookRepository.findAll(PageRequest.of(page, 6)).getTotalPages();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<Publisher> getPublishers() {
        final List<Publisher> publishers = new LinkedList<>();
        publisherRepository.findAll().iterator().forEachRemaining(publishers::add);
        return publishers;
    }

    @Override
    public List<Genre> getGenres() {
        final List<Genre> genres = new LinkedList<>();
        genreRepository.findAll().iterator().forEachRemaining(genres::add);
        return genres;
    }

    @Override
    public void updateBook(Long id, String title, List<Long> genres, Integer status, String publisher, String author) {
        Book book = bookRepository.findById(id).orElseGet(Book::new);
        Publisher publisher1 = publisherRepository.findByPublisherNameIgnoreCase(publisher).orElseGet(Publisher::new);
        publisher1.setPublisherName(publisher);
        Author author1 = authorRepository.findByNameIgnoreCase(author).orElseGet(Author::new);
        author1.setName(author);
        List<Genre> genres1 = genreRepository.findByIdIn(genres);
        book.setGenres(genres1);
        book.setBkPublisher(publisher1);
        book.setBkAuthor(author1);
        book.setName(title);
        book.setBookStatus(status);
        bookRepository.save(book);
    }

    @Override
    public List<Author> getAuthors() {
        final List<Author> authors = new LinkedList<>();
        authorRepository.findAll().iterator().forEachRemaining(authors::add);
        return authors;
    }
}
