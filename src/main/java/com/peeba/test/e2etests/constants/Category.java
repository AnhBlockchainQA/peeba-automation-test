package com.peeba.test.e2etests.constants;

import lombok.Getter;

import java.util.Random;

public enum Category {
    HOME("Home & Living"),
    PETS("Pets"),
    MEN("Men"),
    WOMEN("Women"),
    BEAUTY("Beauty & Wellness"),
    KITCHEN("Kitchen"),
    ACCESSORIES("Accessories"),
    KIDS("Kids & Baby"),
    STATIONERY("Stationery");

    @Getter
    private String category;

    Category(String category){
        this.category = category;
    }

    public static Category randomCategory(){
        return Category.values()[new Random().nextInt(Category.values().length)];
    }

}
