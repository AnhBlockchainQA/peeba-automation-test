package com.peeba.test.e2etests.constants;

import lombok.Getter;

import java.util.Random;

public enum MenuBar {
    BRAND("Brand"),
    PRODUCT("Product");

    @Getter
    private String tabName;

    MenuBar(String tabName) {
        this.tabName = tabName;
    }
}
