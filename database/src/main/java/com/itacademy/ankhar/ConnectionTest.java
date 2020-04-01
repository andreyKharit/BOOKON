/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.util.JdbcProviderUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        Connection connection = JdbcProviderUtil.getInstance().getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println(metaData.getDatabaseProductName());

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users.ankhar_authors");
        while (resultSet.next()) {
            String results = String.format(
                    "%s %s",
                    resultSet.getString("author_id"),
                    resultSet.getString("author_name")
                    );
            System.out.println(results);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
