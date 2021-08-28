package com.peeba.test.e2etests.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserActionService {

    @Autowired
    private ApplicationContext ctx;

//    public void mouseOverElement(WebElement target){
//        Actions actions = new Actions(this.ctx.getBean(WebDriver.class));
//        actions.moveToElement(target).build();
//    }
//
//    public void clickOnElement(WebElement target){
//        Actions actions = new Actions(this.ctx.getBean(WebDriver.class));
//        actions.moveToElement(target).click().build().perform();
//    }
}
