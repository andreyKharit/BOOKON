/*
 * Last updated: 4/19/20, 6:23 PM
 * Author: Andrey Kharitonenko
 */

/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.dao.DaoUsersHibernate;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.extensions.IDaoBooks;
import com.itacademy.ankhar.extensions.IDaoUsers;
import com.itacademy.ankhar.factory.DaoBookFactory;
import com.itacademy.ankhar.factory.DaoTypeFactoryI;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.factory.DaoUserFactory;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

public class JpaTest {

    @Test
    public void jpaTest() throws Exception {
//        Genre genreTest = new Genre();
//        genreTest.setGenreName("Romance");

//        EntityManager entityManager = HibernateUtil.getEntityManager("test");
//        entityManager.getTransaction().begin();
//        entityManager.persist(genreTest);
//        entityManager.getTransaction().commit();
//        entityManager.close();

//        IDaoEntity<Genre> daoEntity = DaoGenreHibernate.getDao();
//        System.out.println(daoEntity.create(genreTest));

//        User user = new User();
//        user.setUserName("sasha");
//        user.setUserPassword("21232f297a57a5a743894a0e4a801fc3");
//        DaoUsersHibernate.getDao().create(user);
//        System.out.println(DaoUsersHibernate.getDao().findByUsername("admin"));
//        List<User> allAuthors = DaoUsersHibernate.getDao().getAll();

        DaoTypeFactoryI<IDaoBooks> daoTypeFactoryI = DaoBookFactory.getInstance();
        IDaoEntity<Book> daoEntity = daoTypeFactoryI.getDao(DaoTypesEnum.HIBERNATE);
        List<Book> bookList = daoEntity.getAll();
        bookList.stream().
                map(c -> c.getAuthor().getName() + " " + c.getName() + " " +
                        c.getPublisher().getPublisherName()
                ).forEach(System.out::println);
        System.out.println(daoEntity.getAll().get(0).getName());
        List<Genre> genres = daoEntity.getAll().get(0).getGenres();
        System.out.println("---------------------------------------------");
        for (Genre genre : genres) {
            String genreName = genre.getGenreName();
            System.out.println(genreName);
        }
//        genres.forEach(genre -> System.out.print(genre.getGenreName()));
    }
}
