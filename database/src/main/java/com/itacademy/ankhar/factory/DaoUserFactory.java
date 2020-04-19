/*
 * Last updated: 4/2/20, 1:22 AM
 * User: Andrey Kharitonenko
 */

package com.itacademy.ankhar.factory;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.dao.DaoUsersHibernate;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.extensions.IDaoUsers;

public class DaoUserFactory implements DaoTypeFactoryI<IDaoUsers> {
    private static DaoUserFactory daoUserFactory;

    private DaoUserFactory(){}

    public static DaoUserFactory getInstance(){
        if (daoUserFactory == null) {
            synchronized (DaoUserFactory.class) {
                if (daoUserFactory == null) {
                    daoUserFactory = new DaoUserFactory();
                }
            }
        }
        return daoUserFactory;
    }

    @Override
    public IDaoUsers getDao(DaoTypesEnum daoType) {
        switch (daoType){
            case JDBC: return DaoUsersJdbc.getDao();
            case HIBERNATE: return DaoUsersHibernate.getDao();
            //TODO SPRING IMPLEMENTATION?
            default: throw new IllegalArgumentException("Unknown DAO type.");
        }
    }
}
