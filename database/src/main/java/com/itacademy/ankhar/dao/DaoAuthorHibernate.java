/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.dao;

import com.itacademy.ankhar.Author;
import com.itacademy.ankhar.extensions.IDaoAuthors;
import com.itacademy.ankhar.util.HibernateUtil;
import com.itacademy.ankhar.util.JdbcProviderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

//TODO
public class DaoAuthorHibernate implements IDaoAuthors {

    private static DaoAuthorHibernate entity = new DaoAuthorHibernate();
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private DaoAuthorHibernate() {
    }

    public static DaoAuthorHibernate getDao() {
        if (entity == null) {
            synchronized (DaoAuthorHibernate.class) {
                if (entity == null) {
                    entity = new DaoAuthorHibernate();
                }
            }
        }
        return entity;
    }

    private static final Logger LOGGER = LogManager.getLogger(DaoAuthorHibernate.class);

    public Long getByName(String name) throws Exception {
        LOGGER.info("Trying to get Author by name.");
        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
            final Root<Author> root = criteriaQuery.from(Author.class);
            criteriaQuery.select(root).
                    where(criteriaBuilder.equal(root.get("name"), name));

            final List<Author> found = session.createQuery(criteriaQuery).getResultList();
            session.close();
            if (found.size() != 1) {
                return -1L;
            } else
                return found.get(0).getAuthorId();
        } catch (HibernateException error) {
            LOGGER.error("Error getting Author entity.");
            throw error;
        }
    }

    @Override
    public Author get(Long id) throws Exception {
        LOGGER.info("Trying to get Author by name.");
        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
            final Root<Author> root = criteriaQuery.from(Author.class);
            criteriaQuery.select(root).
                    where(criteriaBuilder.equal(root.get("authorId"), id));
            final Author found = session.createQuery(criteriaQuery).getSingleResult();
            session.close();
            return found;
        } catch (Exception error) {
            LOGGER.error("Error getting Author entity.");
            return null;
        }
    }

    @Override
    public List<Author> getAll() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Trying to get all Author entities.");
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
            final Root<Author> root = criteriaQuery.from(Author.class);
            criteriaQuery.select(root);

            final List<Author> found = session.createQuery(criteriaQuery).getResultList();

            session.close();
            return found;
        } catch (HibernateException error) {
            LOGGER.error("Error getting all Author entities.");
            throw error;
        }
    }

    @Override
    public Long create(Author record) throws Exception {
        LOGGER.info("Trying to create new Author.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users.ankhar_authors (author_name) VALUES (?)")) {
                statement.setString(1, record.getName());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    LOGGER.info("Error creating new Author.");
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public Long update(Author record) throws Exception {
        LOGGER.info("Trying to update Author.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users.ankhar_authors SET author_name = ? WHERE author_id = ?")) {
                statement.setString(1, record.getName());
                statement.setLong(2, record.getAuthorId());
                int i = statement.executeUpdate();
                if (i == 1) {
                    return null;
                } else {
                    LOGGER.info("Error updating Author.");
                    throw new Exception();
                }
            }
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        LOGGER.info("Trying to delete Author.");
        try (Connection connection = JdbcProviderUtil.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                int i = statement.executeUpdate("DELETE FROM users.ankhar_authors WHERE author_id = " + id);
                if (i == 1) {
                    return true;
                } else {
                    LOGGER.info("Error deleting Author.");
                    throw new Exception();
                }
            }
        }
    }
}
