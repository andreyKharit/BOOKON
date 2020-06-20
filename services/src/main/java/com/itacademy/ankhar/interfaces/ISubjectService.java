/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

import com.itacademy.ankhar.entities.User;

import java.util.List;

public interface ISubjectService {
    List<User> getSubjects();
    boolean deleteUser(Long userId) throws Exception;
    boolean updateUserStatus(Long userId, String status) throws Exception;
}
