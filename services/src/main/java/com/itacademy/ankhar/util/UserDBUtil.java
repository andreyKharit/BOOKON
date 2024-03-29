/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.extensions.IDaoUsers;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.factory.DaoUserFactory;

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
        IDaoUsers daoUsers = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
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
        DaoUsersJdbc daoUsers = DaoUsersJdbc.getDao();
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
