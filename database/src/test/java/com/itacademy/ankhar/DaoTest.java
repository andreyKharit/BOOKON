/*
 * Last updated: 4/19/20, 6:22 PM
 * Author: Andrey Kharitonenko
 */

/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.dao.DaoAuthorJdbc;
import com.itacademy.ankhar.dao.IDaoEntity;
import com.itacademy.ankhar.dao.DaoUsersJdbc;
import com.itacademy.ankhar.entities.Author;
import com.itacademy.ankhar.entities.User;
import com.itacademy.ankhar.factory.DaoAuthorFactory;
import com.itacademy.ankhar.factory.DaoTypeFactoryI;
import org.junit.Test;

public class DaoTest {
    @Test
    public void daoTest() throws Exception {
        DaoTypeFactoryI daoFactory = DaoAuthorFactory.getInstance();
        IDaoEntity<Author> daoAuthors = DaoAuthorJdbc.getDao();
        IDaoEntity<User> daoUsers = DaoUsersJdbc.getDao();

//        List<Author> allAuthors = daoAuthors.getAll();
//        allAuthors.stream().
//                map(c -> c.getId() + " " + c.getName())
//                .forEach(System.out::println);

//        DaoEntityI<Book> daoBook = DaoBookJdbc.getEntity();
//
//        List<Book> allBooks = daoBook.getAll();
//        allBooks.stream().
//                map(c -> c.getAuthorId() + " " + c.getName())
//                .forEach(System.out::println);
//
//        Author author = new Author();
//        author.setName("Mahalam");
//        daoAuthors.create(author);
//
//        allAuthors.stream().
//                map(c -> c.getId() + " " + c.getName())
//                .forEach(System.out::println);
//        System.out.println(daoAuthors.get((long) 5).getName());
//
//        List<User> allUsers = daoUsers.getAll();
//        allUsers.stream().
//                map(c -> c.getUserId() + " " + c.getUserName() + " " +
//                        c.getUserPassword() + " " + c.getUserStatus())
//                .forEach(System.out::println);
    }
}
