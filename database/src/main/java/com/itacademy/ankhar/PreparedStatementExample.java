/*
 * Copyright (c) 2020
 * Last updated: 3/10/20, 6:58 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import java.sql.*;

public class PreparedStatementExample {
    public static final String AUTHOR_BY_NAME =
            "SELECT * FROM users.ankhar_authors " +
                    "WHERE author_id > ? AND author_id < ?";

    public static void main(String[] args) throws Exception {
        try (Connection connection = JdbcProvider.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(AUTHOR_BY_NAME)) {
                statement.setString(1, "2");
                statement.setString(2, "5");
                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        String result = String.format(
                                "%s %s",
                                results.getString("author_id"),
                                results.getString("author_name")
                        );
                        System.out.println(result);
                    }
                }
            }

            try (CallableStatement callableStatement = connection.prepareCall("CALL get_author_by_id(?, ?)")) {
                callableStatement.setInt(1, 2);
                callableStatement.registerOutParameter(2, Types.VARCHAR);
                boolean execute = callableStatement.execute();
                String string = callableStatement.getString(2);
                System.out.println(string);
            }
        }
    }
}
