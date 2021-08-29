package com.peeba.test.e2etests.authentication;

import com.peeba.test.e2etests.SpringBaseTestNGTest;
import com.peeba.test.e2etests.annotations.TakeScreenshot;
import com.peeba.test.e2etests.listener.AllureReportListener;
import com.peeba.test.e2etests.pages.home.HomePage;
import com.peeba.test.e2etests.pages.login.LoginPopup;
import com.peeba.test.e2etests.processor.UserData;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Objects;

@Log4j2
@Listeners(AllureReportListener.class)
public class TC000_LoginTest extends SpringBaseTestNGTest {

    private UserData userData;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPopup popup;

    @BeforeClass
    @Parameters({"user-registration-data-file"})
    public void setUp(String userDataFile) throws IOException {
        log.info("Setup the test...");
        this.homePage.goTo(url);
        this.homePage.isAt();
        userData = UserData.get(System.getProperty("user.dir") + userDataFile).get(1);
        System.out.println(Objects.isNull(context));
    }

    @Test(priority = 1, description = "Verify that we logged in successfully to the web")
    @Severity(SeverityLevel.NORMAL)
    @Step("User: Login to the app")
    @Description("Test case description: Login to the page with valid credentials")
    public void login(){
        log.info("Login to the app...");
        this.homePage.getHeaderComponent().clickOnLoginLink();
        this.popup.login(userData.getEmail(), userData.getPassword());
        this.homePage.getHeaderComponent().clickOnUserAvatarIcon();
        this.homePage.getHeaderComponent().verifyLoginSuccessful(userData.getUserName());
    }

}
