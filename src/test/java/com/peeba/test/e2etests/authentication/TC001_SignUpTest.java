package com.peeba.test.e2etests.authentication;

import com.github.javafaker.Faker;
import com.peeba.test.e2etests.SpringBaseTestNGTest;
import com.peeba.test.e2etests.listener.AllureReportListener;
import com.peeba.test.e2etests.pages.home.HomePage;
import com.peeba.test.e2etests.pages.signup.SignUpPopup;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Log4j2
public class TC001_SignUpTest extends SpringBaseTestNGTest {

    @Autowired
    private Faker faker;

    @Autowired
    private HomePage homePage;

    @Autowired
    private SignUpPopup signUpPopup;

    @BeforeClass
    public void setUp(){
        this.homePage.goTo(url);
        this.homePage.isAt();
    }

    @Test
    public void signUp(){
        this.homePage.getHeaderComponent().clickOnSignUpButton();
        this.signUpPopup.getFirstScreen().signUp(faker.bothify("??????##@1secmail.com"));
    }
}
