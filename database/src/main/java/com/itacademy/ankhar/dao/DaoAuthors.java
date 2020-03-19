/*
 * Copyright (c) 2020
 * Last updated: 3/12/20, 8:39 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Author;
import com.itacademy.ankhar.JdbcProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAuthors implements DaoTestInterface<Author> {

    private static final Logger LOGGER = LogManager.getLogger(DaoAuthors.class);

    @Override
    public Author get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Author> getAll() throws Exception {
        LOGGER.info("Trying to get all Authors.");
        List<Author> results = new ArrayList<>();
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users.ankhar_authors")) {
                    LOGGER.info("Creating Authors list.");
                    while (resultSet.next()) {
                        Author author = new Author();
                        author.setId(resultSet.getLong("author_id"));
                        author.setName(resultSet.getString("author_name"));
                        results.add(author);
                        LOGGER.info("Added Author to list.");
                    }
                    LOGGER.info("Finished creating Authors list.");
                }
            } catch (Exception e) {
                //TODO custom exception
                LOGGER.error("Can't get all Authors.", e);
                throw e;
            }
        }
        LOGGER.info("Printing results.");
        return results;
    }

    @Override
    public Long create(Author record) throws Exception {
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users.ankhar_authors (author_name) VALUES (45)")) {
                statement.setString(1, record.getName());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public Long update(Author record) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
