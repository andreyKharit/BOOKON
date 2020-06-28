/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.interfaces.IAuthorizationService;
import com.itacademy.ankhar.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementationAuthorizationService implements IAuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String authorize(String login) {
        User user = userRepository.findByUserName(login).orElse(null);
        if (user != null) {
            return user.getUserPassword();
        } else return null;
    }
}