package com.peeba.test.e2etests.constants;

import lombok.Getter;

public enum ApplicationMessage {
    ORDER_CONFIRMATION_MESSAGE("Thank you for your order!");

    @Getter
    private String message;

    ApplicationMessage(String message) {
        this.message = message;
    }
}
