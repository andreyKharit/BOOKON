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
import com.itacademy.ankhar.util.UserDBUtil;
import org.apache.commons.codec.digest.DigestUtils;

public class ImplementationAuthorizationService implements IAuthorizationService {
    @Override
    public boolean authorize(String login, String password) {
        IDaoUsers daoUsers = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        UserDBUtil userDBUtils = UserDBUtil.getInstance();
        if (userDBUtils.exists(login)) {
            try {
                User user = daoUsers.get(daoUsers.findByUsername(login));
                //checking login and password
                if (user.getUserName().equals(login) &&
                        user.getUserPassword().
                                equals(DigestUtils.md2Hex(password))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}