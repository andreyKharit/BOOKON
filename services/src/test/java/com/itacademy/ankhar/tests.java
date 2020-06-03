/*
 * Last updated: 4/19/20, 6:20 PM
 * Author: Andrey Kharitonenko
 */

/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import com.itacademy.ankhar.extensions.IDaoAuthors;
import com.itacademy.ankhar.factory.DaoAuthorFactory;
import com.itacademy.ankhar.factory.DaoTypesEnum;
import com.itacademy.ankhar.impl.ImplementationAuthorizationService;
import com.itacademy.ankhar.impl.ImplementationBookCreatorService;
import com.itacademy.ankhar.repositories.BookRepository;
import com.itacademy.ankhar.repositories.UserRepository;
import com.itacademy.ankhar.util.UserDBUtil;
import com.itacademy.ankhar.util.libraryDBUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context-services.xml"})
public class tests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void passwordHexTest() {
        System.out.println(DigestUtils.sha512Hex("admin"));
        ImplementationAuthorizationService test = new ImplementationAuthorizationService();
        if (test.authorize("Harry", "pass")) {
            System.out.println("done");
        }
        System.out.println(UserDBUtil.getInstance().getStatus("Harry"));
    }

    @Test
    public void DBUtilTests() throws Exception {
        Assert.assertEquals("4", Long.toString(libraryDBUtil.getInstance().publisherExists("Petrolium")));
        Assert.assertEquals("-1", Long.toString(libraryDBUtil.getInstance().publisherExists("Hammer minus Hammer")));
    }

    @Test
    public void userCreateTest() throws Exception {
        User test = (userRepository.findByUserName("admin").orElse(null));
        Assert.assertNotNull(test);
        Book book = bookRepository.findById(22L).orElse(null);
        book.getGenres().stream().map(Genre::getGenreName).forEach(System.out::println);
    }

    @Test
    public void createrTestExisting() throws Exception {
        ImplementationBookCreatorService bookCreatorService = new ImplementationBookCreatorService();        String[] sample = new String[2];
        String[] sample2 = new String[1];
        sample2[0] = "7";
        bookCreatorService.createBookEntry("Java 9", "Jim Rook", "Petrolium", sample2);
    }

    @Test
    public void createrTestNew() throws Exception {
        ImplementationBookCreatorService bookCreatorService = new ImplementationBookCreatorService();
        String[] sample = new String[2];
        sample[0] = "5";
        sample[1] = "2";
        bookCreatorService.createBookEntry("Test Book 7", "Test Author 7", "Test Publisher 7", sample);
    }

    @Test
    public void genreListTest() throws Exception {
        String[] list = new String[3];
        list[0] = "1";
        list[1] = "2";
        list[2] = "3";
        List<Genre> genres = libraryDBUtil.getInstance().genreListPackager(list);
        for (Genre genre : genres) {
            System.out.println(genre.getGenreName());
        }
    }

    @Test
    public void authorDaoTest() throws Exception {
        IDaoAuthors daoAuthors = DaoAuthorFactory.getInstance().getDao(DaoTypesEnum.HIBERNATE);
        Author test = daoAuthors.get(100L);
        Assert.assertNull(test);
    }
}