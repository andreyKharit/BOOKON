/*
 * Copyright (c) 2020
 * Last updated: 3/12/20, 8:49 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import javax.persistence.*;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"author_id", "author_name"}))
@Entity(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
