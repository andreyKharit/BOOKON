/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final Logger LOGGER = LogManager.getLogger(HibernateUtil.class);
    private static EntityManagerFactory entityManagerFactory;
    private static SessionFactory sessionFactory;

    public static EntityManager getEntityManager(String unitName) {
        if (entityManagerFactory == null) {
            synchronized (HibernateUtil.class) {
                if (entityManagerFactory == null) {
                    LOGGER.info("Creating EntityManager.");
                    entityManagerFactory = Persistence.createEntityManagerFactory(unitName);
                }
            }
        }
        return entityManagerFactory.createEntityManager();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    LOGGER.info("Creating SessionFactory.");
                    sessionFactory = new Configuration().configure().buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }

    public static void close() {
        LOGGER.info("Trying to close EntityManagerFactory.");
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            LOGGER.info("Closed.");
        }
        LOGGER.info("Trying to close SessionFactory");
        if (sessionFactory != null) {
            sessionFactory.close();
            LOGGER.info("Closed.");
        }
    }
}
