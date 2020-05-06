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
import com.itacademy.ankhar.impl.ImplementationBookCreatorService;
import com.itacademy.ankhar.util.UserDBUtil;
import com.itacademy.ankhar.util.libraryDBUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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

    @Test
    public void DBUtilTests() throws Exception {
        System.out.println(libraryDBUtil.getInstance().authorExists("Mahalam"));
        System.out.println(libraryDBUtil.getInstance().bookExists("Bible 2"));
        Assert.assertEquals("6", Long.toString(libraryDBUtil.getInstance().publisherExists("Hammer and Hammer")));
        Assert.assertEquals("-1", Long.toString(libraryDBUtil.getInstance().publisherExists("Hammer minus Hammer")));
    }

    @Test
    public void createrTest() throws Exception {
        ImplementationBookCreatorService bookCreatorService = new ImplementationBookCreatorService();
        List<String> sample = new LinkedList<>();
        sample.add("Bye");
        bookCreatorService.createBookEntry("Harammer", "Tuskan Origami", "Two One", sample);
    }
}