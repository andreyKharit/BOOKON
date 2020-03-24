/*
 * Copyright (c) 2020
 * Last updated: 3/12/20, 8:37 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import java.util.List;

public interface DaoJdbcInterface<T> {
    T get(Long id) throws Exception;
    List<T> getAll() throws Exception;
    Long create(T record) throws Exception;
    Long update(T record) throws Exception;
    boolean delete(Long id) throws Exception;
}
