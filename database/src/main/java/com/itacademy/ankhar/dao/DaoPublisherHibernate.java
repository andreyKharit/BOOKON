/*
 * Last updated: 5/5/20, 5:00 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.entities.Publisher;
import com.itacademy.ankhar.extensions.IDaoPublishers;
import com.itacademy.ankhar.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DaoPublisherHibernate implements IDaoPublishers {

    private static DaoPublisherHibernate entity = new DaoPublisherHibernate();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private DaoPublisherHibernate() {
    }

    public static DaoPublisherHibernate getDao() {
        if (entity == null) {
            synchronized (DaoPublisherHibernate.class) {
                if (entity == null) {
                    entity = new DaoPublisherHibernate();
                }
            }
        }
        return entity;
    }

    private static final Logger LOGGER = LogManager.getLogger(DaoPublisherHibernate.class);

    @Override
    public Publisher get(Long id) throws Exception {
        LOGGER.info("Trying to get Publisher by name.");
        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Publisher> criteriaQuery = criteriaBuilder.createQuery(Publisher.class);
            final Root<Publisher> root = criteriaQuery.from(Publisher.class);
            criteriaQuery.select(root).
                    where(criteriaBuilder.equal(root.get("publisherId"), id));
            final Publisher found = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error getting Publisher entity.");
            throw error;
        }
    }

    @Override
    public List<Publisher> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Trying to get all Publisher entities.");
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Publisher> criteriaQuery = criteriaBuilder.createQuery(Publisher.class);
            final Root<Publisher> root = criteriaQuery.from(Publisher.class);
            criteriaQuery.select(root);

            final List<Publisher> found = session.createQuery(criteriaQuery).getResultList();

            session.close();
            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error getting all Publisher entities.");
            throw error;
        }
    }

    @Override
    public Long create(Publisher record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Creating new Publisher entity.");
            session.getTransaction().begin();
            session.saveOrUpdate(record);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error creating Publisher: " + error);
            throw error;
        }
        LOGGER.info("Done. Entity ID is: " + record.getId());
        return record.getId();
    }

    @Override
    public Long update(Publisher record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Updating Publisher entity with ID: " + record.getId());
            session.getTransaction().begin();
            session.update(record);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error updating Publisher: " + error);
            throw error;
        }
        LOGGER.info("Done. Updated entity ID is: " + record.getId());
        return record.getId();
    }

    @Override
    public boolean delete(Long id) throws Exception {
        final Publisher entityToDelete = get(id);
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Deleting Publisher entity with ID: " + id);
            session.getTransaction().begin();
            session.delete(entityToDelete);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error deleting Publisher: " + error);
            throw error;
        }
        LOGGER.info("Done deleting entity.");
        return true;
    }
}
