///*
// * Last updated: 5/14/20, 8:55 PM
// * Author: Andrey Kharitonenko
// */
//
//package com.itacademy.ankhar.impl;
//
//import TransactionData;
//import org.aspectj.lang.ProceedingJoinPoint;
//
//public class TransactionServiceAdvice {
//    public void beforeAction() {
//        System.out.println("Before.");
//    }
//
//    public void beforeActionArgs(TransactionData data) {
//        System.out.println("Before args.");
//    }
//
//    public void afterAction() {
//        System.out.println("After.");
//    }
//
//    public void afterExceptionAction(Exception e) {
//        System.out.println("Exception error.");
//    }
//
//    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Method around before.");
//        final Object proceed = joinPoint.proceed();
//        System.out.println("Method around after.");
//        return proceed;
//    }
//}
