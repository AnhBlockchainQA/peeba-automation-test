package com.peeba.test.e2etests.constants;

import lombok.Getter;

import java.util.Random;

public enum StripeCardNumber {
    VISA("4242424242424242"),
    VISA_DEBIT("4000056655665556"),
    MASTER("5555555555554444"),
    MASTER_DEBIT("5200828282828210"),
    MASTER_PREPAID("5105105105105100"),
    AMERICAN_EXPRESS("378282246310005"),
    DISCOVER("6011000990139424");

    @Getter
    private String cardNumber;

    StripeCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public static StripeCardNumber randomCardNumber(){
        return StripeCardNumber.values()[new Random().nextInt(StripeCardNumber.values().length)];
    }
}
