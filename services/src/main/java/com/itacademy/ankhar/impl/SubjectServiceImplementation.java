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

import java.util.ArrayList;
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
        List<User> subjectList = new ArrayList<>();
        try {
            DaoJdbcInterface<User> daoUsers = new DaoUsers();
            return daoUsers.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
