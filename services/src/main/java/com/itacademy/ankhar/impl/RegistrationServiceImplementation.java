/*
 * Copyright (c) 2020
 * Last updated: 3/25/20, 10:17 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoJdbcInterface;
import com.itacademy.ankhar.dao.DaoUsers;
import com.itacademy.ankhar.interfaces.RegistrationService;
import com.itacademy.ankhar.util.HashMD5Converter;
import com.itacademy.ankhar.util.UserDBUtils;

public class RegistrationServiceImplementation implements RegistrationService {

    @Override
    public boolean createUser(String login, String password) throws Exception {
        if (!UserDBUtils.getInstance().exists(login)) {
            try {
                User newUser = new User();
                newUser.setUserName(login);
                newUser.setUserPassword(HashMD5Converter.getInstance().stringToMD5(password));
                DaoJdbcInterface<User> userDaoJdbc = DaoUsers.getEntity();
                userDaoJdbc.create(newUser);
                return true;
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }
}
