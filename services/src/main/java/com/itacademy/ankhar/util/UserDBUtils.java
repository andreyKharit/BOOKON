/*
 * Copyright (c) 2020
 * Last updated: 3/25/20, 10:10 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoJdbcInterface;
import com.itacademy.ankhar.dao.DaoUsers;

public class UserDBUtils {

    private static UserDBUtils userDBUtilsInstance;
    private UserDBUtils() {
    }

    public static UserDBUtils getInstance() {
        if (userDBUtilsInstance == null) {
            synchronized (UserDBUtils.class) {
                if (userDBUtilsInstance == null) {
                    userDBUtilsInstance = new UserDBUtils();
                }
            }
        }
        return userDBUtilsInstance;
    }

    //checks if user already exists in db
    public boolean exists(String login) {
        DaoUsers daoUsers = DaoUsers.getEntity();
        try {
            if (daoUsers.findByUsername(login) != -1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //checks for user status
    public String getStatus(String login) {
        DaoUsers daoUsers = DaoUsers.getEntity();
        UserDBUtils userDBUtils = UserDBUtils.getInstance();
        if (userDBUtils.exists(login)) {
            try {
                User user = daoUsers.get(daoUsers.findByUsername(login));
                return user.getUserStatus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
