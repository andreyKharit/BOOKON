/*
 * Last updated: 4/14/20, 10:12 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.extensions;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.IDaoEntity;

public interface IDaoUsers extends IDaoEntity<User> {
    Long findByUsername(String name) throws Exception;
}
