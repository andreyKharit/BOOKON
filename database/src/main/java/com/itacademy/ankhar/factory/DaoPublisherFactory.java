/*
 * Last updated: 5/5/20, 5:05 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.factory;

import com.itacademy.ankhar.dao.DaoPublisherHibernate;
import com.itacademy.ankhar.extensions.IDaoPublishers;

public class DaoPublisherFactory implements DaoTypeFactoryI<IDaoPublishers> {
    private static DaoPublisherFactory daoPublisherFactory;

    private DaoPublisherFactory() {
    }

    public static DaoPublisherFactory getInstance() {
        if (daoPublisherFactory == null) {
            synchronized (DaoPublisherFactory.class) {
                if (daoPublisherFactory == null) {
                    daoPublisherFactory = new DaoPublisherFactory();
                }
            }
        }
        return daoPublisherFactory;
    }

    @Override
    public IDaoPublishers getDao(DaoTypesEnum daoType) {
        switch (daoType) {
            case JDBC:
                return DaoPublisherHibernate.getDao();
            case HIBERNATE:
                return DaoPublisherHibernate.getDao();
            //TODO SPRING IMPLEMENTATION?
            default:
                throw new IllegalArgumentException("Unknown DAO type.");
        }
    }
}
