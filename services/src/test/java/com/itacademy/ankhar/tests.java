/*
 * Last updated: 4/19/20, 6:20 PM
 * Author: Andrey Kharitonenko
 */

/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.impl.ImplementationAuthorizationService;
import com.itacademy.ankhar.util.UserDBUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class tests {
    @Test
    public void passwordHexTest() {
        System.out.println(DigestUtils.sha512Hex("admin"));
        ImplementationAuthorizationService test = new ImplementationAuthorizationService();
        if (test.authorize("Harry", "pass")) {
            System.out.println("done");
        }
        System.out.println(UserDBUtil.getInstance().getStatus("Harry"));
    }
}
