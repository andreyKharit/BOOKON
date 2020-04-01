/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoUsersJdbc;

public class UserDBUtil {

    private static UserDBUtil userDBUtilsInstance;
    private UserDBUtil() {
    }

    public static UserDBUtil getInstance() {
        if (userDBUtilsInstance == null) {
            synchronized (UserDBUtil.class) {
                if (userDBUtilsInstance == null) {
                    userDBUtilsInstance = new UserDBUtil();
                }
            }
        }
        return userDBUtilsInstance;
    }

    //checks if user already exists in db
    public boolean exists(String login) {
        DaoUsersJdbc daoUsers = DaoUsersJdbc.getEntity();
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
        DaoUsersJdbc daoUsers = DaoUsersJdbc.getEntity();
        UserDBUtil userDBUtils = UserDBUtil.getInstance();
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
