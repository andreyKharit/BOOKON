/*
 * Copyright (c) 2020
 * Last updated: 3/24/20, 4:20 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashMD5Converter {
    private static final HashMD5Converter instance = new HashMD5Converter();
    private HashMD5Converter() {
    }

    public static HashMD5Converter getInstance() {
        return instance;
    }

    public String stringToMD5(String string) {
        return DigestUtils.md5Hex(string);
    }
}
