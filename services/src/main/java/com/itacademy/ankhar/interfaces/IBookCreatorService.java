/*
 * Last updated: 5/4/20, 8:26 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.interfaces;

import java.util.List;

public interface IBookCreatorService {
    boolean createBookEntry(String bookName,
                            String authorName,
                            String publisherName,
                            String... genres) throws Exception;
}
