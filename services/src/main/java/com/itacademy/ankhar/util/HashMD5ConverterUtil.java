/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashMD5ConverterUtil {
    private static HashMD5ConverterUtil instance = new HashMD5ConverterUtil();
    private HashMD5ConverterUtil() {
    }

    public static HashMD5ConverterUtil getInstance() {
        if (instance == null) {
            synchronized (HashMD5ConverterUtil.class) {
                if (instance == null) {
                    instance = new HashMD5ConverterUtil();
                }
            }
        }
        return instance;
    }

    public String stringToMD5(String stringToEncode) {
        return DigestUtils.md5Hex(stringToEncode);
    }
}
