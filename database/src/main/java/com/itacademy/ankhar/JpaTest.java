/*
 * Copyright (c) 2020
 * Last updated: 3/19/20, 7:49 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {

    public static void main(String[] args) {

        Author author = new Author();
        author.setName("Halamas");

        EntityManager entityManager = HibernateUtil.getEntity();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        entityManager.close();
        HibernateUtil.close();
    }
}
