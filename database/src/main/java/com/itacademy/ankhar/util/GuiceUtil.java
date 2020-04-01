/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.itacademy.ankhar.dao.DaoAuthorHibernate;
import com.itacademy.ankhar.dao.DaoEntityI;

public class GuiceUtil implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(DaoEntityI.class).to(DaoAuthorHibernate.class).in(Scopes.SINGLETON);
    }
}
