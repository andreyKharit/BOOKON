/*
 * Copyright (c) 2020
 * Last updated: 3/19/20, 7:43 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import com.google.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("test");
    public static EntityManager getEntity() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        entityManagerFactory.close();
    }
}
