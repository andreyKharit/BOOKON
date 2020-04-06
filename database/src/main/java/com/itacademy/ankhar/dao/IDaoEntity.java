/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import java.util.List;

public interface IDaoEntity<T> {
    T get(Long id) throws Exception;
    List<T> getAll() throws Exception;
    Long create(T record) throws Exception;
    Long update(T record) throws Exception;
    boolean delete(Long id) throws Exception;
}
