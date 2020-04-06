/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.util.JdbcProviderUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoBookJdbc implements IDaoEntity<Book> {

    private static DaoBookJdbc entity = new DaoBookJdbc();

    private DaoBookJdbc() {
    }

    public static DaoBookJdbc getDao() {
        if (entity == null) {
            synchronized (DaoBookJdbc.class) {
                if (entity == null) {
                    entity = new DaoBookJdbc();
                }
            }
        }
        return entity;
    }

    //TODO
    @Override
    public Book get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Book> getAll() throws Exception {
        List<Book> results = new ArrayList<>();
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
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
