/*
 * Last updated: 5/26/20, 2:25 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context-database.xml"})
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createTest() {
        User user = new User();
        user.setUserName("Martin");
        user.setUserPassword("admin");
        final User save = userRepository.save(user);
        System.out.println(save.getUserName());
        boolean truth = userRepository.existsByUserName("admin");
        Assert.assertTrue(truth);
    }
}
