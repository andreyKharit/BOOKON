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

import java.util.Iterator;
import java.util.List;

public class ImplementationBookCreatorService implements IBookCreatorService {
    private final DaoTypeFactoryI<IDaoBooks> daoTypeFactoryI = DaoBookFactory.getInstance();
    private final IDaoEntity<Book> daoEntity = daoTypeFactoryI.getDao(DaoTypesEnum.HIBERNATE);
    private final IDaoEntity<Author> daoAuthor = DaoAuthorFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
    private final IDaoEntity<Publisher> daoPublisher = DaoPublisherFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
    private final IDaoEntity<Genre> daoGenre = DaoGenreFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);

    @Override
    public boolean createBookEntry(String bookName, String authorName, String publisherName, List<String> genres) throws Exception {
        if (libraryDBUtil.getInstance().bookExists(bookName) != -1L) {
            return false;
        }
        Book newBook = new Book();
        newBook.setName(bookName);
        //adding new author if needed
            Author newAuthor = new Author();
            newAuthor.setName(authorName);
            newBook.setAuthor(newAuthor);
        //adding new publisher if needed
            Publisher newPublisher = new Publisher();
            newPublisher.setPublisherName(publisherName);
            newBook.setPublisher(newPublisher);
//        Iterator<String> genreIterator = genres.iterator();
//        while (genreIterator.hasNext()) {
//
//        }
        daoEntity.create(newBook);
        return true;
    }
}
