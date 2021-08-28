package com.peeba.test.e2etests.checkout;

import com.peeba.test.e2etests.SpringBaseTestNGTest;
import com.peeba.test.e2etests.listener.AllureReportListener;
import com.peeba.test.e2etests.pages.home.HomePage;
import com.peeba.test.e2etests.pages.product.ProductComponent;
import com.peeba.test.e2etests.pages.login.LoginPopup;
import com.peeba.test.e2etests.processor.Category;
import com.peeba.test.e2etests.processor.UserData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class TC002_CheckoutTest extends SpringBaseTestNGTest {

    private UserData userData;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPopup popup;

    @Autowired
    private ProductComponent productPage;

    @BeforeClass
    @Parameters({"user-registration-data-file"})
    public void setUp(String userDataFile) throws IOException {
        this.homePage.goTo(url);
        this.homePage.isAt();
        userData = UserData.get(System.getProperty("user.dir") + userDataFile).get(1);

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

    @Test(priority = 1, description = "Verify that we can go to the branch by name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test case description: Click on the branch and verify we can see brand products")
    public void click(){
        this.homePage.getHeaderComponent().clickOnCategoryWithName(Category.randomCategory().getCategory());
        this.productPage.isAt();
    }




}
