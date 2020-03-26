/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoUsers;
import com.itacademy.ankhar.interfaces.AuthorizationService;
import com.itacademy.ankhar.util.HashMD5Converter;
import com.itacademy.ankhar.util.UserDBUtils;

public class AuthorizationServiceImplementation implements AuthorizationService {
    @Override
    public boolean authorize(String login, String password) {
        DaoUsers daoUsers = new DaoUsers();
        UserDBUtils userDBUtils = UserDBUtils.getInstance();
        if (userDBUtils.exists(login)) {
            try {
                User user = daoUsers.get(daoUsers.findByUsername(login));
                //checking login and password
                if (user.getUserName().equals(login) &&
                        user.getUserPassword().
                                equals(HashMD5Converter.getInstance().stringToMD5(password))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}