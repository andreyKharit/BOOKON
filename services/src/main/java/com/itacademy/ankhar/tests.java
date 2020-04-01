/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.impl.AuthorizationServiceImplementation;
import com.itacademy.ankhar.util.HashMD5ConverterUtil;
import com.itacademy.ankhar.util.UserDBUtil;

public class tests {
    public static void main(String[] args) {
        System.out.println(HashMD5ConverterUtil.getInstance().stringToMD5("admin"));
        AuthorizationServiceImplementation test = new AuthorizationServiceImplementation();
        if (test.authorize("Harry", "pass")) {
            System.out.println("done");
        }
        System.out.println(UserDBUtil.getInstance().getStatus("Harry"));
    }
}
