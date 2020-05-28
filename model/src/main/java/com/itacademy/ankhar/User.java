/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "ankhar_users")
@Component
public class User {
    @Id
    @Column(name = "contacts_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String userPassword;
    @PrePersist
    private void prePersist() {
        if (this.userStatus == null) {
            this.userStatus = "user";
        }
    }
    @Column(name = "user_status", nullable = false)
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
