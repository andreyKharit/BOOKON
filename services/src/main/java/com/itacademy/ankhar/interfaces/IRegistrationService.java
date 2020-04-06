/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

public interface IRegistrationService {
    boolean createUser(String login, String password) throws Exception;
}
