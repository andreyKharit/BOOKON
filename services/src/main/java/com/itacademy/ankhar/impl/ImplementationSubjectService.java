/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.extensions.IDaoUsers;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.factory.DaoUserFactory;
import com.itacademy.ankhar.interfaces.ISubjectService;
import com.itacademy.ankhar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ImplementationSubjectService implements ISubjectService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getSubjects() {
        final List<User> userList = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);
        return userList;
    }

    @Override
    public User getSubjectById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public boolean updateUserStatus(Long userId, String status) throws Exception {
        User user = userRepository.findById(userId).orElseGet(null);
        if (user != null) {
            user.setUserStatus(status);
            userRepository.save(user);
            return true;
        }
        else return false;
    }
}
