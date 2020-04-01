/*
 * Last updated: 4/2/20, 1:19 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.factory;

import com.itacademy.ankhar.dao.DaoEntityI;

//TODO CHECK IF RIGHT
public interface DaoTypeFactoryI <T extends DaoEntityI> {
    T getDao(DaoTypesEnum daoType);
}
