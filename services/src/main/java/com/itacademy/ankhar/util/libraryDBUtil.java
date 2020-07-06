/*
 * Last updated: 5/4/20, 9:19 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.itacademy.ankhar.entities.Book;
import com.itacademy.ankhar.entities.Genre;
import com.itacademy.ankhar.entities.Publisher;
import com.itacademy.ankhar.extensions.IDaoAuthors;
import com.itacademy.ankhar.extensions.IDaoGenres;
import com.itacademy.ankhar.factory.*;
import com.itacademy.ankhar.repositories.BookRepository;
import com.itacademy.ankhar.repositories.GenreRepository;
import com.itacademy.ankhar.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "library")
public class libraryDBUtil {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private BookRepository bookRepository;

    public Long authorExists(String authorName) throws Exception {
        IDaoAuthors daoAuthors = DaoAuthorFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        return daoAuthors.getByName(authorName);
    }

    public Long bookExists(String bookName) throws Exception {
        Book book = bookRepository.findByName(bookName).orElseGet(null);
        if (book != null) return book.getId();
        return -1L;
    }

    public Long publisherExists(String publisherName) throws Exception {
        Publisher publisher = publisherRepository.findByPublisherNameIgnoreCase(publisherName).orElseGet(null);
        if (publisher != null) return publisher.getId();
        return -1L;
    }

    public Long genreExists(String genreName) throws Exception {
        Genre genreFound = genreRepository.findByGenreName(genreName).orElseGet(null);
        if (genreFound != null) return genreFound.getId();
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
