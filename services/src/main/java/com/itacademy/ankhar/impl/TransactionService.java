/*
 * Last updated: 5/14/20, 7:35 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.impl;

import com.itacademy.ankhar.TransactionData;
import com.itacademy.ankhar.TransactionResult;

import java.util.Random;

public class TransactionService {

    public TransactionResult doTransaction(TransactionData transactionData){
        final int i = new Random().nextInt(3);
        return TransactionResult.values()[i];
    }
}
