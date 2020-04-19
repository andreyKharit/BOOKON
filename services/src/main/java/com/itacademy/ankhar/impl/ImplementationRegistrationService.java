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
import com.itacademy.ankhar.util.UserDBUtil;
import org.apache.commons.codec.digest.DigestUtils;

public class ImplementationRegistrationService implements IRegistrationService {

    @Override
    public boolean createUser(String login, String password) throws Exception {
        if (!UserDBUtil.getInstance().exists(login)) {
            try {
                User newUser = new User();
                newUser.setUserName(login);
                newUser.setUserPassword(DigestUtils.md2Hex(password));
                IDaoUsers userDao = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
                userDao.create(newUser);
                return true;
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }
}
