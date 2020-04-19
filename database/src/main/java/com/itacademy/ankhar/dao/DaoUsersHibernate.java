/*
 * Last updated: 4/6/20, 6:05 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.User;
import com.itacademy.ankhar.extensions.IDaoUsers;
import com.itacademy.ankhar.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class DaoUsersHibernate implements IDaoUsers {
    private static DaoUsersHibernate daoUsersHibernate;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(DaoUsersHibernate.class);

    private DaoUsersHibernate() {
    }

    public static DaoUsersHibernate getDao() {
        if (daoUsersHibernate == null) {
            synchronized (DaoUsersHibernate.class) {
                if (daoUsersHibernate == null) {
                    daoUsersHibernate = new DaoUsersHibernate();
                }
            }
        }
        return daoUsersHibernate;
    }

    @Override
    public User get(Long id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Finding User entity with ID: " + id);
            User found = session.find(User.class, id);
            session.close();
            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error finding User with ID: " + id + ", error: " + error);
            throw error;
        }
    }

    @Override
    public List<User> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.error("Creating native query.");
            final NativeQuery<User> nativeQuery = session.
                    createNativeQuery("SELECT * FROM users.ankhar_users;", User.class);
            List<User> resultList = nativeQuery.getResultList();
            session.close();
            return resultList;
        } catch (HibernateException e) {
            LOGGER.error("Error getting all User entities: " + e);
            throw e;
        }
    }

    @Override
    public Long create(User record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Creating new User entity.");
            session.getTransaction().begin();
            session.persist(record);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error creating User: " + error);
            throw error;
        }
        LOGGER.info("Done. Entity ID is: " + record.getUserId());
        return record.getUserId();
    }

    @Override
    public Long update(User record) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Updating User entity with ID: " + record.getUserId());
            session.getTransaction().begin();
            session.update(record);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error updating User: " + error);
            throw error;
        }
        LOGGER.info("Done. Updated entity ID is: " + record.getUserId());
        return record.getUserId();
    }

    @Override
    public boolean delete(Long id) throws Exception {
        final User entityToDelete = get(id);
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Deleting User entity with ID: " + id);
            session.getTransaction().begin();
            session.delete(entityToDelete);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            LOGGER.error("Error creating User: " + error);
            throw error;
        }
        LOGGER.info("Done deleting entity.");
        return true;
    }

    public Long findByUsername(String name) throws HibernateException {
        LOGGER.info("Trying to get User by name.");
        try (Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM user c WHERE c.userName = :name", User.class);
            query.setParameter("name", name);
            return query.getSingleResult().getUserId();
        } catch (NoResultException e) {
            LOGGER.error(e);
            return (long) -1;
        }
    }
}
