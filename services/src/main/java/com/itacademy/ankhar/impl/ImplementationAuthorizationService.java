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
import com.itacademy.ankhar.interfaces.IAuthorizationService;
import com.itacademy.ankhar.repositories.UserRepository;
import com.itacademy.ankhar.util.UserDBUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class ImplementationAuthorizationService implements IAuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authorize(String login, String password) {
//        IDaoUsers daoUsers = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
//        UserDBUtil userDBUtils = UserDBUtil.getInstance();
        if (userRepository.existsByUserName(login)) {
            try {
                User user = userRepository.findByUserName(login).orElse(null);
                //checking login and password
                if (user != null && user.getUserName().equals(login) &&
                        user.getUserPassword().
                                equals(DigestUtils.sha512Hex(password))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

//
        }
        return false;
    }
}