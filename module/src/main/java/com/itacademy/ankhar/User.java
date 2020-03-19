/*
 * Copyright (c) 2020
 * Last updated: 3/19/20, 1:43 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

public class User {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userStatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
