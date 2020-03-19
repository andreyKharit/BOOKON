/*
 * Copyright (c) 2020
 * Last updated: 3/13/20, 9:40 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

public class Book {
    private String name;
    private Long authorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
