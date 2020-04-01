/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.interfaces.AuthorizationServiceI;
import com.itacademy.ankhar.util.HashMD5ConverterUtil;
import com.itacademy.ankhar.util.UserDBUtil;

public class AuthorizationServiceImplementation implements AuthorizationServiceI {
    @Override
    public boolean authorize(String login, String password) {
        DaoUsersJdbc daoUsers = DaoUsersJdbc.getEntity();
        UserDBUtil userDBUtils = UserDBUtil.getInstance();
        if (userDBUtils.exists(login)) {
            try {
                User user = daoUsers.get(daoUsers.findByUsername(login));
                //checking login and password
                if (user.getUserName().equals(login) &&
                        user.getUserPassword().
                                equals(HashMD5ConverterUtil.getInstance().stringToMD5(password))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}