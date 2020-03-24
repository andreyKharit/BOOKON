/*
 * Copyright (c) 2020
 * Last updated: 3/12/20, 8:39 PM
 * Book: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.util.JdbcProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoBook implements DaoJdbcInterface<Book> {


    //TODO
    @Override
    public Book get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Book> getAll() throws Exception {
        List<Book> results = new ArrayList<>();
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users.ankhar_books")) {
                    while (resultSet.next()) {
                        Book book = new Book();
                        book.setAuthorId(resultSet.getLong("author_id"));
                        book.setName(resultSet.getString("book_name"));
                        results.add(book);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        return results;
    }

    @Override
    public Long create(Book record) {
        return null;
    }

    @Override
    public Long update(Book record) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
