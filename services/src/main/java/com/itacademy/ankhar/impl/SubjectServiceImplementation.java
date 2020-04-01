/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoEntityI;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.interfaces.SubjectServiceI;

import java.util.List;

public class SubjectServiceImplementation implements SubjectServiceI {
    private static SubjectServiceI subjectInstance;

    private SubjectServiceImplementation() {
    }

    public static SubjectServiceI getInstance() {
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
            DaoEntityI<User> daoUsers = DaoUsersJdbc.getEntity();
            return daoUsers.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUser(Long userId) throws Exception {
        try {
            DaoEntityI<User> userDaoJdbc = DaoUsersJdbc.getEntity();
            userDaoJdbc.delete(userId);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean updateUserStatus(Long userId, String status) throws Exception {
        try {
            DaoEntityI<User> userDaoJdbc = DaoUsersJdbc.getEntity();
            User updateUser = userDaoJdbc.get(userId);
            updateUser.setUserStatus(status);
            userDaoJdbc.update(updateUser);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

}
