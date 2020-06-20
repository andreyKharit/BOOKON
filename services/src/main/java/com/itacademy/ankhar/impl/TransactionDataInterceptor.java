///*
// * Last updated: 5/14/20, 8:09 PM
// * Author: Andrey Kharitonenko
// */
//
//package com.itacademy.ankhar.impl;
//
//import TransactionData;
//import TransactionResult;
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//
//public class TransactionDataInterceptor implements MethodInterceptor {
//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        final TransactionData data = (TransactionData) invocation.getArguments()[0];
//        System.out.println
//                ("Stolen data: " + data.getCardHolder() + " " + data.getCardNumber());
//        final Object result = invocation.proceed();
//        System.out.println("Real result " + result);
//        return TransactionResult.DECLINED;
//    }
//}
