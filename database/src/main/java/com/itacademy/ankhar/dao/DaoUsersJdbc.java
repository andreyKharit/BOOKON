/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.util.JdbcProviderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//TODO users
public class DaoUsersJdbc implements DaoEntityI<User> {

    private static final Logger LOGGER = LogManager.getLogger(DaoUsersJdbc.class);
    private static DaoUsersJdbc entity = new DaoUsersJdbc();

    private DaoUsersJdbc() {
    }

    public static DaoUsersJdbc getEntity() {
        if (entity == null) {
            synchronized (DaoUsersJdbc.class) {
                if (entity == null) {
                    entity = new DaoUsersJdbc();
                }
            }
        }
        return entity;
    }

    public Long findByUsername(String name) throws Exception {
        LOGGER.info("Trying to get User by name.");
        int exists = -1;
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
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
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
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
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
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
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
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
        LOGGER.info("Trying to update User.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users.ankhar_users SET user_status = ? WHERE contacts_id = ?")) {
                statement.setString(1, record.getUserStatus());
                statement.setLong(2, record.getUserId());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    LOGGER.info("Error updating User.");
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        LOGGER.info("Trying to delete User.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                int i = statement.executeUpdate("DELETE FROM users.ankhar_users WHERE contacts_id = " + id);
                if (i == 1) {
                    return true;
                } else {
                    LOGGER.info("Error deleting User.");
                    throw new Exception();
                }
            }
        }
    }
}
