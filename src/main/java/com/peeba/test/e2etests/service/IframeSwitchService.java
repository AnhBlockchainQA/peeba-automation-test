package com.peeba.test.e2etests.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class IframeSwitchService {

    @Autowired
    private ApplicationContext ctx;

    public void switchToFrameByIndex(final int index) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        driver.switchTo().frame(index);
    }

    public void switchToFrameWithName(final String name) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        driver.switchTo().frame(name);
    }

    public void switchToFrameWithSelector(final WebElement element) {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        driver.switchTo().frame(element);
    }

    public void switchBackToOriginalIframe() {
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        driver.switchTo().defaultContent();
    }

}
