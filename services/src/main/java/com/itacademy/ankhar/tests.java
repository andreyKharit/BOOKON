/*
 * Copyright (c) 2020
 * Last updated: 3/24/20, 4:29 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.impl.AuthorizationServiceImplementation;
import com.itacademy.ankhar.util.HashMD5Converter;
import com.itacademy.ankhar.util.UserDBUtils;

public class tests {
    public static void main(String[] args) {
        System.out.println(HashMD5Converter.getInstance().stringToMD5("admin"));
        AuthorizationServiceImplementation test = new AuthorizationServiceImplementation();
        if (test.authorize("Harry", "pass")) {
            System.out.println("done");
        }
        System.out.println(UserDBUtils.getInstance().getStatus("Harry"));
    }
}
