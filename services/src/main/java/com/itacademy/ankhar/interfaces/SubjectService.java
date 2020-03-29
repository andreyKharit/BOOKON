/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

import com.itacademy.ankhar.User;

import java.util.List;

public interface SubjectService {
    List<User> getSubjects();
    boolean deleteUser(Long userId) throws Exception;
}
