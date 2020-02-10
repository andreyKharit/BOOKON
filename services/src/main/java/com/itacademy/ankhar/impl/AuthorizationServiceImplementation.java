package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.interfaces.AuthorizationService;

public class AuthorizationServiceImplementation implements AuthorizationService {
    @Override
    public Long authorize(String login, String password) {
        if ("admin".equals(login) && "admin".equals(password)) {
            return 1l;
        } else {
            return 2l;
        }
    }
}