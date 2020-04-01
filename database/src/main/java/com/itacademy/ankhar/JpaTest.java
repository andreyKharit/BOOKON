/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {

    public static void main(String[] args) {

        Author author = new Author();
        author.setName("Robert Cook");

        EntityManager entityManager = HibernateUtil.getEntity();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        entityManager.close();
        HibernateUtil.close();
    }
}
