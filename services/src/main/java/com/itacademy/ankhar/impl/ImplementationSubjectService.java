/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.interfaces.ISubjectService;

import java.util.List;

public class ImplementationSubjectService implements ISubjectService {
    private static ISubjectService subjectInstance;

    private ImplementationSubjectService() {
    }

    public static ISubjectService getInstance() {
        if (subjectInstance == null) {
            synchronized (ImplementationSubjectService.class) {
                if (subjectInstance == null) {
                    subjectInstance = new ImplementationSubjectService();
                }
            }
        }
        return subjectInstance;
    }

    @Override
    public List<User> getSubjects() {
        try {
            IDaoEntity<User> daoUsers = DaoUsersJdbc.getDao();
            return daoUsers.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUser(Long userId) throws Exception {
        try {
            IDaoEntity<User> userDaoJdbc = DaoUsersJdbc.getDao();
            userDaoJdbc.delete(userId);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean updateUserStatus(Long userId, String status) throws Exception {
        try {
            IDaoEntity<User> userDaoJdbc = DaoUsersJdbc.getDao();
            User updateUser = userDaoJdbc.get(userId);
            updateUser.setUserStatus(status);
            userDaoJdbc.update(updateUser);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

}
