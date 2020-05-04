/*
 * Last updated: 4/22/20, 11:03 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.factory;

import com.itacademy.ankhar.dao.DaoBookHibernate;
import com.itacademy.ankhar.dao.DaoBookJdbc;
import com.itacademy.ankhar.extensions.IDaoBooks;

public class DaoBookFactory implements DaoTypeFactoryI<IDaoBooks> {
    private static DaoBookFactory daoBookFactory;

    private DaoBookFactory() {
    }

    public static DaoBookFactory getInstance() {
        if (daoBookFactory == null) {
            synchronized (DaoBookFactory.class) {
                if (daoBookFactory == null) {
                    daoBookFactory = new DaoBookFactory();
                }
            }
        }
        return daoBookFactory;
    }

    @Override
    public IDaoBooks getDao(DaoTypesEnum daoType) {
        switch (daoType) {
            case JDBC:
                return DaoBookJdbc.getDao();
            case HIBERNATE:
                return DaoBookHibernate.getDao();
            //TODO SPRING IMPLEMENTATION?
            default:
                throw new IllegalArgumentException("Unknown DAO type.");
        }
    }
}
