package com.peeba.test.e2etests.config;

import com.peeba.test.e2etests.annotations.LazyConfiguration;
import com.peeba.test.e2etests.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@LazyConfiguration
public class WebDriverConfig {

    // Apply Spring IoC here. Object instantiation is handled by Spring
    // Bean is Java objects created by Spring Container

    /**
     * Cast FirefoxDriver to interface WebDriver so we have FirefoxDriver instance.
     *
     * @return FirefoxDriver
     */
    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new FirefoxDriver(options);
        WebDriver driver = new FirefoxDriver();
        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
        return driver;
    }

    /**
     * Cast ChromeDriver to interface WebDriver so we have FirefoxDriver instance.
     *
     * @return ChromeDriver
     */
    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();
        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
        return driver;
    }

}
