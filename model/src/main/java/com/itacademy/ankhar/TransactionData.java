/*
 * Last updated: 5/14/20, 7:33 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar;

import java.time.LocalDate;

public class TransactionData {
    private Long cardNumber;
    private LocalDate expire;
    private String cardHolder;
    private Integer cvv;

    public TransactionData() {
    }

    public TransactionData(Long cardNumber, LocalDate expire, String cardHolder, Integer cvv) {
        this.cardNumber = cardNumber;
        this.expire = expire;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
}
