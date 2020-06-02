/*
 * Last updated: 5/4/20, 9:19 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.Genre;
import com.itacademy.ankhar.Publisher;
import com.itacademy.ankhar.extensions.IDaoAuthors;
import com.itacademy.ankhar.extensions.IDaoBooks;
import com.itacademy.ankhar.extensions.IDaoGenres;
import com.itacademy.ankhar.extensions.IDaoPublishers;
import com.itacademy.ankhar.factory.*;

import java.util.List;

public class libraryDBUtil {
    private static libraryDBUtil libraryDBUtilInstance;

    private libraryDBUtil() {
    }

    public static libraryDBUtil getInstance() {
        if (libraryDBUtilInstance == null) {
            synchronized (UserDBUtil.class) {
                if (libraryDBUtilInstance == null) {
                    libraryDBUtilInstance = new libraryDBUtil();
                }
            }
        }
        return libraryDBUtilInstance;
    }

    public Long authorExists(String authorName) throws Exception {
        IDaoAuthors daoAuthors = DaoAuthorFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        return daoAuthors.getByName(authorName);
    }

    public Long bookExists(String bookName) throws Exception {
        IDaoBooks daoBooks = DaoBookFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        List<Book> bookList = daoBooks.getAll();
        for (Book current : bookList) {
            if (current.getName().equals(bookName)) {
                return current.getId();
            }
        }
        return -1L;
    }

    public Long publisherExists(String publisherName) throws Exception {
        IDaoPublishers daoPublishers = DaoPublisherFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        List<Publisher> publisherList = daoPublishers.getAll();
        for (Publisher current : publisherList) {
            if (current.getPublisherName().equals(publisherName)) {
                return current.getPublisherId();
            }
        }
        return -1L;
    }

    public Long genreExists(String genreName) throws Exception {
        IDaoGenres daoGenres = DaoGenreFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        List<Genre> publisherList = daoGenres.getAll();
        for (Genre current : publisherList) {
            if (current.getGenreName().equals(genreName)) {
                return current.getGenreId();
            }
        }
        return -1L;
    }

    public List<Genre> genreListPackager(String... stringGenreIDList) {
        IDaoGenres daoGenres = DaoGenreFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        Long[] arrayIds = new Long[stringGenreIDList.length];
        for (int i = 0; i < arrayIds.length; i++) {
            arrayIds[i] = Long.parseLong(stringGenreIDList[i]);
        }
        return daoGenres.getGenresByIds(arrayIds);
    }
}
