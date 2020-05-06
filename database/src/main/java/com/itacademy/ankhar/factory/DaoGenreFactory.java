/*
 * Last updated: 5/5/20, 5:05 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.factory;

import com.itacademy.ankhar.dao.DaoGenreHibernate;
import com.itacademy.ankhar.dao.DaoPublisherHibernate;
import com.itacademy.ankhar.extensions.IDaoGenres;
import com.itacademy.ankhar.extensions.IDaoPublishers;

public class DaoGenreFactory implements DaoTypeFactoryI<IDaoGenres> {
    private static DaoGenreFactory daoGenreFactory;

    private DaoGenreFactory() {
    }

    public static DaoGenreFactory getInstance() {
        if (daoGenreFactory == null) {
            synchronized (DaoGenreFactory.class) {
                if (daoGenreFactory == null) {
                    daoGenreFactory = new DaoGenreFactory();
                }
            }
        }
        return daoGenreFactory;
    }

    @Override
    public IDaoGenres getDao(DaoTypesEnum daoType) {
        switch (daoType) {
            case JDBC:
                return DaoGenreHibernate.getDao();
            case HIBERNATE:
                return DaoGenreHibernate.getDao();
            //TODO SPRING IMPLEMENTATION?
            default:
                throw new IllegalArgumentException("Unknown DAO type.");
        }
    }
}
