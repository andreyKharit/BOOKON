/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoEntityI;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.interfaces.RegistrationServiceI;
import com.itacademy.ankhar.util.HashMD5ConverterUtil;
import com.itacademy.ankhar.util.UserDBUtil;

public class RegistrationServiceImplementation implements RegistrationServiceI {

    @Override
    public boolean createUser(String login, String password) throws Exception {
        if (!UserDBUtil.getInstance().exists(login)) {
            try {
                User newUser = new User();
                newUser.setUserName(login);
                newUser.setUserPassword(HashMD5ConverterUtil.getInstance().stringToMD5(password));
                DaoEntityI<User> userDaoJdbc = DaoUsersJdbc.getEntity();
                userDaoJdbc.create(newUser);
                return true;
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }
}
