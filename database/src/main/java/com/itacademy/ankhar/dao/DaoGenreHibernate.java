/*
 * Last updated: 4/6/20, 5:30 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Genre;
import com.itacademy.ankhar.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class DaoGenreHibernate implements IDaoEntity<Genre> {
    private static DaoGenreHibernate daoGenreHibernate;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(DaoGenreHibernate.class);

    private DaoGenreHibernate() {
    }

    public static DaoGenreHibernate getDao() {
        if (daoGenreHibernate == null) {
            synchronized (DaoAuthorHibernate.class) {
                if (daoGenreHibernate == null) {
                    daoGenreHibernate = new DaoGenreHibernate();
                }
            }
        }
        return daoGenreHibernate;
    }

    @Override
    public Genre get(Long id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Finding Genre entity with ID: " + id);
            return session.find(Genre.class, id);
        } catch (HibernateException error) {
            LOGGER.error("Error finding Genre with ID: " + id + ", error: " + error);
            throw error;
        }
    }

    @Override
    public List<Genre> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            final NativeQuery<Genre> nativeQuery = session.
                    createNativeQuery("SELECT * FROM ankhar_genres;", Genre.class);
            return nativeQuery.getResultList();
        } catch (HibernateException e) {
            LOGGER.error("Error getting all Genre entities: " + e);
            throw e;
        }
    }

    @Override
    public Long create(Genre record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Creating new Genre entity.");
            session.getTransaction().begin();
            session.persist(record);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error creating Genre: " + error);
            throw error;
        }
        LOGGER.info("Done. Entity ID is: " + record.getGenreId());
        return record.getGenreId();
    }

    @Override
    public Long update(Genre record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Updating Genre entity with ID: " + record.getGenreId());
            session.getTransaction().begin();
            session.update(record);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error updating Genre: " + error);
            throw error;
        }
        LOGGER.info("Done. Updated entity ID is: " + record.getGenreId());
        return record.getGenreId();
    }

    @Override
    public boolean delete(Long id) throws Exception {
        final Genre entityToDelete = get(id);
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Deleting Genre entity with ID: " + id);
            session.getTransaction().begin();
            session.delete(entityToDelete);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error creating Genre: " + error);
            throw error;
        }
        LOGGER.info("Done deleting entity.");
        return true;
    }
}
