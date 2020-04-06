/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.dao.DaoGenreHibernate;
import com.itacademy.ankhar.dao.DaoUsersHibernate;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.factory.DaoAuthorFactory;
import com.itacademy.ankhar.factory.DaoTypeFactoryI;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.factory.DaoUserFactory;
import com.itacademy.ankhar.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaTest {

    public static void main(String[] args) throws Exception {
//        Genre genreTest = new Genre();
//        genreTest.setGenreName("Romance");

//        EntityManager entityManager = HibernateUtil.getEntityManager("test");
//        entityManager.getTransaction().begin();
//        entityManager.persist(genreTest);
//        entityManager.getTransaction().commit();
//        entityManager.close();

//        IDaoEntity<Genre> daoEntity = DaoGenreHibernate.getDao();
//        System.out.println(daoEntity.create(genreTest));

        User user = new User();
        user.setUserName("sasha");
        user.setUserPassword("21232f297a57a5a743894a0e4a801fc3");
//        DaoUsersHibernate.getDao().create(user);
//        System.out.println(DaoUsersHibernate.getDao().findByUsername("admin"));
//        List<User> allAuthors = DaoUsersHibernate.getDao().getAll();
//        allAuthors.stream().
//                map(c -> c.getUserId() + " " + c.getUserName())
//                .forEach(System.out::println);
        DaoTypeFactoryI<IDaoEntity<User>> daoF = DaoUserFactory.getInstance();
        IDaoEntity<User> dao = daoF.getDao(DaoTypesEnum.HIBERNATE);
    }
}
