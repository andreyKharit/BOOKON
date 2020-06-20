/*
 * Last updated: 4/19/20, 6:03 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.extensions;

import com.itacademy.ankhar.entities.Author;
import com.itacademy.ankhar.dao.IDaoEntity;

public interface IDaoAuthors extends IDaoEntity<Author> {
    Long getByName(String authorName) throws Exception;
}
