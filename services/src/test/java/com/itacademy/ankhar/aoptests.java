///*
// * Last updated: 5/14/20, 7:40 PM
// * Author: Andrey Kharitonenko
// */
//
//package com.itacademy.ankhar;
//
//import TransactionData;
//import TransactionResult;
//import com.itacademy.ankhar.impl.TransactionDataInterceptor;
//import com.itacademy.ankhar.impl.TransactionService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.aop.framework.ProxyFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.time.LocalDate;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("test-context.xml")
//public class aoptests {
//    @Autowired
//    private TransactionService transactionService;
//
//    @Test
//    public void springTestTest() {
//        final TransactionData transactionData = new TransactionData(31231231L, LocalDate.now(),"Sasha",325);
//        final TransactionResult transactionResult = transactionService.doTransaction(transactionData);
//        System.out.println(transactionResult);
//    }
//
//    @Test
//    public void springWeaverTest() {
//        final ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(transactionService);
//        proxyFactory.addAdvice(new TransactionDataInterceptor());
//        TransactionService proxyTransactionService = (TransactionService) proxyFactory.getProxy();
//
//        final TransactionData transactionData = new TransactionData(31231231L, LocalDate.now(),"Sasha",325);
//        final TransactionResult transactionResult = proxyTransactionService.doTransaction(transactionData);
//        System.out.println(transactionResult);
//    }
//}
