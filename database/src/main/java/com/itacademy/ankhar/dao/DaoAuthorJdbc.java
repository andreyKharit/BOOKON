/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Author;
import com.itacademy.ankhar.extensions.IDaoAuthors;
import com.itacademy.ankhar.util.JdbcProviderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAuthorJdbc implements IDaoAuthors {

    private static DaoAuthorJdbc entity = new DaoAuthorJdbc();

    private DaoAuthorJdbc() {
    }

    public static DaoAuthorJdbc getDao() {
        if (entity == null) {
            synchronized (DaoAuthorJdbc.class) {
                if (entity == null) {
                    entity = new DaoAuthorJdbc();
                }
            }
        }
        return entity;
    }

    private static final Logger LOGGER = LogManager.getLogger(DaoAuthorJdbc.class);

    public Long getByName(String name) throws Exception {
        LOGGER.info("Trying to get Author by name.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT * FROM users.ankhar_authors WHERE author_name = ?")) {
                preparedStatement.setString(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getLong("author_id");
                    }
                    return null;
                }
            }
        }
    }

    @Override
    public Author get(Long id) throws Exception {
        LOGGER.info("Trying to get Author by Id.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT * FROM users.ankhar_authors WHERE author_id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Author author = new Author();
                        author.setId(resultSet.getLong("author_id"));
                        author.setName(resultSet.getString("author_name"));
                        return author;
                    }
                    return null;
                }
            }
        }
    }

    @Override
    public List<Author> getAll() throws Exception {
        LOGGER.info("Trying to get all Authors.");
        List<Author> results = new ArrayList<>();
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users.ankhar_authors")) {
                    LOGGER.info("Creating Authors list.");
                    while (resultSet.next()) {
                        Author author = new Author();
                        author.setId(resultSet.getLong("author_id"));
                        author.setName(resultSet.getString("author_name"));
                        results.add(author);
                        LOGGER.info("Added Author " + author.getName() + " to results list.");
                    }
                    LOGGER.info("Finished creating list.");
                }
            } catch (Exception e) {
                //TODO custom exception
                LOGGER.error("Can't get all Authors.", e);
                throw e;
            }
        }
        return results;
    }

    @Override
    public Long create(Author record) throws Exception {
        LOGGER.info("Trying to create new Author.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users.ankhar_authors (author_name) VALUES (?)")) {
                statement.setString(1, record.getName());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    LOGGER.info("Error creating new Author.");
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public Long update(Author record) throws Exception {
        LOGGER.info("Trying to update Author.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users.ankhar_authors SET author_name = ? WHERE author_id = ?")) {
                statement.setString(1, record.getName());
                statement.setLong(2, record.getId());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    LOGGER.info("Error updating Author.");
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        LOGGER.info("Trying to delete Author.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                int i = statement.executeUpdate("DELETE FROM users.ankhar_authors WHERE author_id = " + id);
                if (i == 1) {
                    return true;
                } else {
                    LOGGER.info("Error deleting Author.");
                    throw new Exception();
                }
            }
        }
    }
}
