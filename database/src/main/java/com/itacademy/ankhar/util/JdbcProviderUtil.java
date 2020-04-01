/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcProviderUtil {

    private static final String PROPERTIES_FILE_NAME = "connection.properties";

    private static final String JDBC_DRIVER_NAME = "driverName";
    private static final String JDBC_URL = "jdbcURL";
    private static final String JDBC_USERNAME = "username";
    private static final String JDBC_PASSWORD = "password";

    private static final JdbcProviderUtil instance = new JdbcProviderUtil();

    private JdbcProviderUtil() {
    }

    public static JdbcProviderUtil getInstance() {
        return instance;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        InputStream in = JdbcProviderUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        Properties properties = new Properties();
        assert in != null;
        properties.load(in);

        String jdbcDriverName = (String) properties.get(JDBC_DRIVER_NAME);
        String jdbcUrl = (String) properties.get(JDBC_URL);
        String jdbcUsername = (String) properties.get(JDBC_USERNAME);
        String jdbcPassword = (String) properties.get(JDBC_PASSWORD);


        Class.forName(jdbcDriverName);
        return DriverManager.getConnection(
                jdbcUrl,
                jdbcUsername, jdbcPassword);
    }
}
