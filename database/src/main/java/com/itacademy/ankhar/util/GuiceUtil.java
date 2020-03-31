/*
 * Copyright (c) 2020
 * Last updated: 3/31/20, 7:57 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.itacademy.ankhar.dao.DaoAuthorsHibernate;
import com.itacademy.ankhar.dao.DaoJdbcInterface;

public class GuiceUtil implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(DaoJdbcInterface.class).to(DaoAuthorsHibernate.class).in(Scopes.SINGLETON);
    }
}
