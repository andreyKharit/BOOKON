/*
 * Copyright (c) 2020
 * Last updated: 3/19/20, 1:45 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.util.JdbcProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//TODO users
public class DaoUsers implements DaoJdbcInterface<User> {

    private static final Logger LOGGER = LogManager.getLogger(DaoUsers.class);
    private static final DaoUsers entity = new DaoUsers();

    private DaoUsers() {}

    public static DaoUsers getEntity() {
        return entity;
    }

    public Long findByUsername(String name) throws Exception {
        LOGGER.info("Trying to get User by name.");
        int exists = -1;
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT * FROM users.ankhar_users WHERE username = ?")) {
                preparedStatement.setString(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        exists = resultSet.getInt("contacts_id");
                    }
                }
            } catch (Exception e) {
                LOGGER.info("Error finding User.", e);
                throw e;
            }
        }
        return (long) exists;
    }

    @Override
    public User get(Long id) throws Exception {
        LOGGER.info("Trying to get User by Id.");
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT * FROM users.ankhar_users WHERE contacts_id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        User user = new User();
                        user.setUserId(resultSet.getLong("contacts_id"));
                        user.setUserName(resultSet.getString("username"));
                        user.setUserPassword(resultSet.getString("password"));
                        user.setUserStatus(resultSet.getString("user_status"));
                        LOGGER.info("User found.");
                        return user;
                    }
                    LOGGER.info("Error finding User.");
                    return null;
                }
            }
        }
    }

    @Override
    public List<User> getAll() throws Exception {
        LOGGER.info("Trying to get all Users.");
        List<User> results = new ArrayList<>();
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users.ankhar_users")) {
                    LOGGER.info("Creating Users list.");
                    while (resultSet.next()) {
                        User user = new User();
                        user.setUserId(resultSet.getLong("contacts_id"));
                        user.setUserName(resultSet.getString("username"));
                        user.setUserPassword(resultSet.getString("password"));
                        user.setUserStatus(resultSet.getString("user_status"));
                        results.add(user);
                        LOGGER.info("Added User " + user.getUserName() + " to results list.");
                    }
                    LOGGER.info("Finished creating list.");
                }
            } catch (Exception e) {
                //TODO custom exception
                LOGGER.error("Can't get all Users.", e);
                throw e;
            }
        }
        return results;
    }

    @Override
    public Long create(User record) throws Exception {
        LOGGER.info("Trying to create new User.");
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users.ankhar_users (username, password) VALUES (?, ?)")) {
                statement.setString(1, record.getUserName());
                statement.setString(2, record.getUserPassword());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    LOGGER.info("Error creating new User.");
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public Long update(User record) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
