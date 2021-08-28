package com.peeba.test.e2etests;

import com.peeba.test.e2etests.listener.AllureReportListener;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@SpringBootTest
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected ApplicationContext context;

    @Value("${application.url}")
    protected String url;

    @BeforeMethod(alwaysRun = true)
    public void createTestContext(ITestContext context) {
        context.setAttribute("driver", this.context.getBean(WebDriver.class));
    }

}
