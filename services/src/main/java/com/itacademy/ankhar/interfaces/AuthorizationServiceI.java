/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

public interface AuthorizationServiceI {
    boolean authorize(String login, String password);
}
