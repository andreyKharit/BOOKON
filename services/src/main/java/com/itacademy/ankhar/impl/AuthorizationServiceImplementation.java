/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.interfaces.AuthorizationService;

public class AuthorizationServiceImplementation implements AuthorizationService {
    @Override
    public Long authorize(String login, String password) {
        if ("admin".equals(login) && "admin".equals(password)) {
            return 1L;
        } else {
            return 2L;
        }
    }
}