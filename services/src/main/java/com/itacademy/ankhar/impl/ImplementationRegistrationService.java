/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.extensions.IDaoUsers;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.factory.DaoUserFactory;
import com.itacademy.ankhar.interfaces.IRegistrationService;
import com.itacademy.ankhar.repositories.UserRepository;
import com.itacademy.ankhar.util.UserDBUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementationRegistrationService implements IRegistrationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createUser(String login, String password) throws Exception {
        try {
            User newUser = userRepository.findByUserName(login).orElse(null);
            if (newUser == null) {
                newUser = new User();
                newUser.setUserName(login);
                newUser.setUserPassword(DigestUtils.sha512Hex(password));
                userRepository.save(newUser);
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }
}
