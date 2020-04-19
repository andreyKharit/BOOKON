/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.extensions.IDaoUsers;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.factory.DaoUserFactory;
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
            IDaoUsers userDao = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
            return userDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUser(Long userId) throws Exception {
        try {
            IDaoUsers userDao = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
            userDao.delete(userId);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean updateUserStatus(Long userId, String status) throws Exception {
        try {
            IDaoUsers userDao = DaoUserFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
            User updateUser = userDao.get(userId);
            updateUser.setUserStatus(status);
            userDao.update(updateUser);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

}
