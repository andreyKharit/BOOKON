/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

public class Subject {

    private String name;
    private String description;
    private Integer hours;
    private Integer startDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }
}
