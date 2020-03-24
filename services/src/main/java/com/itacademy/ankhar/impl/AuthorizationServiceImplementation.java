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

public class AuthorizationServiceImplementation implements AuthorizationService {
    @Override
    public boolean authorize(String login, String password) {
        DaoUsers daoUsers = new DaoUsers();
        if (exists(login)) {
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

    @Override
    public boolean exists(String login) {
        DaoUsers daoUsers = new DaoUsers();
        try {
            if (daoUsers.findByUsername(login) != -1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getStatus(String login) {
        DaoUsers daoUsers = new DaoUsers();
        if (exists(login)) {
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