/*
 * Last updated: 5/14/20, 8:55 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

public class TransactionServiceAdvice {
    public void beforeAction() {
        System.out.println("Before.");
    }

    public void afterAction() {
        System.out.println("After.");
    }

    public void afterExceptionAction(Exception e) {
        System.out.println("Exception error.");
    }
}
