/*
 * Last updated: 6/27/20, 3:09 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.auth;

import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    ISubjectService subjectService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = subjectService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Can't find user named " + username);
        }
        return new UserSecurity(user);
    }
}
