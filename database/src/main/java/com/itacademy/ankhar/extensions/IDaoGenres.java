/*
 * Last updated: 5/5/20, 5:37 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.extensions;

import com.itacademy.ankhar.Genre;
import com.itacademy.ankhar.dao.IDaoEntity;

import java.util.List;

public interface IDaoGenres extends IDaoEntity<Genre> {
    public List<Genre> getGenresByIds(Long... incomingList);
}
