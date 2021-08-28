package com.peeba.test.e2etests.pages;

import com.github.javafaker.Faker;
import com.peeba.test.e2etests.annotations.LazyAutowired;
import com.peeba.test.e2etests.service.UserActionService;
import io.qameta.allure.AllureLifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @LazyAutowired
    protected UserActionService actionService;

    @LazyAutowired
    protected Faker faker;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();
}
