package com.peeba.test.e2etests.constants;

import lombok.Getter;

public enum RegexConstants {
    EXPIRY_DATE_REGEX("(0[1-9]|10|11|12)\\/([2-6]){2}"),
    ZIP_CODE_REGEX("([0-9]){5}"),
    AMOUNT_REGEX("(?!0|\\.00)[0-9]+(,\\d{3})*(.[0-9]{0,2})");


    @Getter
    private String regEx;

    RegexConstants(String regEx){this.regEx = regEx;}
}
