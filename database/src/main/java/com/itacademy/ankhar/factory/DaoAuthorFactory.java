/*
 * Last updated: 4/2/20, 1:22 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.factory;

import com.itacademy.ankhar.Author;
import com.itacademy.ankhar.dao.DaoAuthorHibernate;
import com.itacademy.ankhar.dao.DaoAuthorJdbc;
import com.itacademy.ankhar.dao.IDaoEntity;

public class DaoAuthorFactory implements DaoTypeFactoryI<IDaoEntity<Author>> {
    private static DaoAuthorFactory daoAuthorFactory;

    private DaoAuthorFactory(){}

    public static DaoAuthorFactory getInstance(){
        if (daoAuthorFactory == null) {
            synchronized (DaoAuthorFactory.class) {
                if (daoAuthorFactory == null) {
                    daoAuthorFactory = new DaoAuthorFactory();
                }
            }
        }
        return daoAuthorFactory;
    }

    @Override
    public IDaoEntity<Author> getDao(DaoTypesEnum daoType) {
        switch (daoType){
            case JDBC: return DaoAuthorJdbc.getDao();
            case HIBERNATE: return DaoAuthorHibernate.getDao();
            //TODO SPRING IMPLEMENTATION?
            default: throw new IllegalArgumentException("Unknown DAO type.");
        }
    }
}
