/*
 * Copyright (c) 2020
 * Last updated: 3/25/20, 10:05 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

public interface RegistrationService {
    boolean createUser(String login, String password) throws Exception;
}
