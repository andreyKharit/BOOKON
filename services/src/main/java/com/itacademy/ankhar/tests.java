/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.impl.ImplementationAuthorizationService;
import com.itacademy.ankhar.util.UserDBUtil;
import org.apache.commons.codec.digest.DigestUtils;

public class tests {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md2Hex("admin"));
        ImplementationAuthorizationService test = new ImplementationAuthorizationService();
        if (test.authorize("Harry", "pass")) {
            System.out.println("done");
        }
        System.out.println(UserDBUtil.getInstance().getStatus("Harry"));
    }
}
