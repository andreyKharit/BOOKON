/*
 * Last updated: 4/21/20, 1:59 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Book;
import com.itacademy.ankhar.extensions.IDaoBooks;
import com.itacademy.ankhar.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DaoBookHibernate implements IDaoBooks {
    private static DaoBookHibernate daoBookHibernate;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(DaoBookHibernate.class);

    private DaoBookHibernate() {
    }

    public static DaoBookHibernate getDao() {
        if (daoBookHibernate == null) {
            synchronized (DaoBookHibernate.class) {
                if (daoBookHibernate == null) {
                    daoBookHibernate = new DaoBookHibernate();
                }
            }
        }
        return daoBookHibernate;
    }

    @Override
    public Book get(Long id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Trying to get Book entity by id: " + id);
            Book found = session.find(Book.class, id);
            session.close();
            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error finding Book by id: " + id);
            throw error;
        }
    }

    @Override
    public List<Book> getAll() throws Exception {
        return null;
    }

    @Override
    public Long create(Book record) throws Exception {
        return null;
    }

    @Override
    public Long update(Book record) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
