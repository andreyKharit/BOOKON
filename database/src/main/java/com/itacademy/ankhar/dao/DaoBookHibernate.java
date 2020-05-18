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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
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
            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error finding Book by id: " + id);
            throw error;
        }
    }

    @Override
    public List<Book> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Trying to get all Book entities.");
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
            final Root<Book> root = criteriaQuery.from(Book.class);
            criteriaQuery.select(root);

            final List<Book> found = session.createQuery(criteriaQuery).getResultList();

            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error getting all Book entities.");
            throw error;
        }
    }

    @Override
    public Long create(Book record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Creating new Book entity.");
            session.getTransaction().begin();
            session.saveOrUpdate(record); //todo
            session.getTransaction().commit();
        } catch (HibernateException error) {
            LOGGER.error("Error creating Book: " + error);
            throw error;
        }
        LOGGER.info("Done. Entity ID is: " + record.getBookId());
        return record.getBookId();
    }

    @Override
    public Long update(Book record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Updating Book entity with ID: " + record.getBookId());
            session.getTransaction().begin();
            session.update(record);
            session.getTransaction().commit();
        } catch (HibernateException error) {
            LOGGER.error("Error updating Book: " + error);
            throw error;
        }
        LOGGER.info("Done. Updated entity ID is: " + record.getBookId());
        return record.getBookId();
    }

    @Override
    public boolean delete(Long id) throws Exception {
        final Book entityToDelete = get(id);
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Deleting Book entity with ID: " + id);
            session.getTransaction().begin();
            session.delete(entityToDelete);
            session.getTransaction().commit();
        } catch (HibernateException error) {
            LOGGER.error("Error deleting Book: " + error);
            throw error;
        }
        LOGGER.info("Done deleting entity.");
        return true;
    }
}
