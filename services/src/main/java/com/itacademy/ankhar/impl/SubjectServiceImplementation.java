/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoJdbcInterface;
import com.itacademy.ankhar.dao.DaoUsers;
import com.itacademy.ankhar.interfaces.SubjectService;
import com.itacademy.ankhar.util.HashMD5Converter;

import java.util.List;

public class SubjectServiceImplementation implements SubjectService {
    private static SubjectService subjectInstance;

    private SubjectServiceImplementation() {
    }

    public static SubjectService getInstance() {
        if (subjectInstance == null) {
            synchronized (SubjectServiceImplementation.class) {
                if (subjectInstance == null) {
                    subjectInstance = new SubjectServiceImplementation();
                }
            }
        }
        return subjectInstance;
    }

    @Override
    public List<User> getSubjects() {
        try {
            DaoJdbcInterface<User> daoUsers = DaoUsers.getEntity();
            return daoUsers.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUser(Long userId) throws Exception {
        try {
            DaoJdbcInterface<User> userDaoJdbc = DaoUsers.getEntity();
            userDaoJdbc.delete(userId);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean updateUserStatus(Long userId, String status) throws Exception {
        try {
            DaoJdbcInterface<User> userDaoJdbc = DaoUsers.getEntity();
            User updateUser = userDaoJdbc.get(userId);
            updateUser.setUserStatus(status);
            userDaoJdbc.update(updateUser);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

}
