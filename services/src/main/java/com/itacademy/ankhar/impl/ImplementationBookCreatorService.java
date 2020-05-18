/*
 * Last updated: 5/4/20, 8:27 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.Author;
import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.Genre;
import com.itacademy.ankhar.Publisher;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.extensions.IDaoBooks;
import com.itacademy.ankhar.factory.*;
import com.itacademy.ankhar.interfaces.IBookCreatorService;
import com.itacademy.ankhar.util.libraryDBUtil;

import java.util.List;

public class ImplementationBookCreatorService implements IBookCreatorService {
    private final DaoTypeFactoryI<IDaoBooks> daoTypeFactoryI = DaoBookFactory.getInstance();
    private final IDaoEntity<Book> daoBook = daoTypeFactoryI.getDao(DaoTypesEnum.HIBERNATE);
    private final IDaoEntity<Author> daoAuthor = DaoAuthorFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
    private final IDaoEntity<Publisher> daoPublisher = DaoPublisherFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);

    private static IBookCreatorService instance;

    public IBookCreatorService getInstance() {
        if (instance == null) {
            synchronized (ImplementationBookCreatorService.class) {
                if (instance == null) {
                    instance = new ImplementationBookCreatorService();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean createBookEntry(String bookName, String authorName, String publisherName, String... genres) throws Exception {
        //stops if entity is duplicate
        if (libraryDBUtil.getInstance().bookExists(bookName) != -1L) {
            return false;
        }
        //else start creating new entity
        Book newBook = new Book();
        newBook.setName(bookName);
        //adding existing author if needed
        Long authorId = libraryDBUtil.getInstance().authorExists(authorName);
        Author newAuthor;
        if (authorId != -1L) {
            newAuthor = daoAuthor.get(authorId);
        } else
        {
            newAuthor = new Author();
            newAuthor.setName(authorName);
        }
        newAuthor.addBooks(newBook);
        //adding existing publisher if needed
        Long publisherId = libraryDBUtil.getInstance().publisherExists(publisherName);
        Publisher newPublisher;
        if (publisherId != -1L) {
            newPublisher = daoPublisher.get(publisherId);
        } else
        {
            newPublisher = new Publisher();
            newPublisher.setPublisherName(publisherName);
        }
        newPublisher.addBooks(newBook);
        //genres check
        List<Genre> genreList = libraryDBUtil.getInstance().genreListPackager(genres);
        newBook.setGenres(genreList);
        //done
        daoBook.create(newBook);
        return true;
    }
}
