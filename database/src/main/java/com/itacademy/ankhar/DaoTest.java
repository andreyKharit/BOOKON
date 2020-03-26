/*
 * Copyright (c) 2020
 * Last updated: 3/12/20, 9:13 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.dao.DaoAuthors;
import com.itacademy.ankhar.dao.DaoBook;
import com.itacademy.ankhar.dao.DaoJdbcInterface;
import com.itacademy.ankhar.dao.DaoUsers;

import java.util.List;

public class DaoTest {
    public static void main(String[] args) throws Exception {
        DaoJdbcInterface<Author> daoAuthors = new DaoAuthors();
        DaoJdbcInterface<User> daoUsers = new DaoUsers();

        List<Author> allAuthors = daoAuthors.getAll();
        allAuthors.stream().
                map(c -> c.getId() + " " + c.getName())
                .forEach(System.out::println);

        DaoJdbcInterface<Book> daoBook = new DaoBook();

        List<Book> allBooks = daoBook.getAll();
        allBooks.stream().
                map(c -> c.getAuthorId() + " " + c.getName())
                .forEach(System.out::println);

        Author author = new Author();
        author.setName("Mahalam");
        daoAuthors.create(author);

        allAuthors.stream().
                map(c -> c.getId() + " " + c.getName())
                .forEach(System.out::println);
        System.out.println(daoAuthors.get((long) 5).getName());

        List<User> allUsers = daoUsers.getAll();
        allUsers.stream().
                map(c -> c.getUserId() + " " + c.getUserName() + " " +
                        c.getUserPassword() + " " + c.getUserStatus())
                .forEach(System.out::println);
    }
}
