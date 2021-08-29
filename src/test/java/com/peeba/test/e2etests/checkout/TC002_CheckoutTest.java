package com.peeba.test.e2etests.checkout;

import com.peeba.test.e2etests.SpringBaseTestNGTest;
import com.peeba.test.e2etests.pages.home.HomePage;
import com.peeba.test.e2etests.pages.login.LoginPopup;
import com.peeba.test.e2etests.pages.product.ProductPage;
import com.peeba.test.e2etests.processor.UserData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
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
    private ProductPage productPage;

    @BeforeClass
    @Parameters({"user-registration-data-file"})
    public void setUp(String userDataFile) throws IOException {
        this.homePage.goTo(url);
        this.homePage.isAt();
        userData = UserData.get(System.getProperty("user.dir") + userDataFile).get(1);

    }

    @Test(priority = 0, description = "Verify that we logged in successfully to the web")
    @Severity(SeverityLevel.NORMAL)
    @Step("User: Login to the app")
    @Description("Test case description: Login to the page with valid credentials")
    public void login(){
        log.info("Login to the app...");
        this.homePage.getHeaderComponent().clickOnLoginLink();
        this.popup.login(userData.getEmail(), userData.getPassword());
        this.productPage.getSuggestBrandsComponent().isAt();
    }

    @Test(priority = 1, description = "Verify that we can go to branch by clicking on brand name", dependsOnMethods = {"login"})
    @Severity(SeverityLevel.NORMAL)
    @Step("User: Click on brand appeared in suggested brands")
    @Description("Test case description: Click on the branch and verify we can see brand products")
    public void clickOnSuggestedBrandWithName(){
         this.productPage.getSuggestBrandsComponent().clickOnSuggestBrandWithName("exampleG");
         this.productPage.getProductBrandComponent().isAt();
    }


    @Test(priority = 2, description = "Verify that we can go to product detail to add product to cart", dependsOnMethods = {"clickOnSuggestedBrandWithName"})
    @Severity(SeverityLevel.NORMAL)
    @Step("User: Click on any product")
    @Description("Test case description: Click on the product to go to product detail page")
    public void clickOnRandomProduct(){
        this.productPage.getProductBrandComponent().clickOnRandomProduct();
        this.productPage.getProductDetailComponent().isAt();
    }
//
//    @Test(priority = 3, description = "Verify that we can select quantity for product to checkout", dependsOnMethods = {"clickOnRandomProduct"})
//    @Severity(SeverityLevel.NORMAL)
//    @Step("User: Select the quantity then click on Add to Cart button")
//    @Description("Test case description: User selects the quantity then click on Add to Cart button")
//    public void clickOnCheckoutButton(){
//        this.productPage.getProductDetailComponent().clickOnQuantityDropList();
//        this.productPage.getProductDetailComponent().clickOnRandomQuantityOption();
//        this.productPage.getProductDetailComponent().clickOnAddToCartButton();
//        this.productPage.getCheckoutComponent().isAt();
//    }
//
//    @Test(priority = 4, description = "Verify that we can place the order", dependsOnMethods = {"clickOnCheckoutButton"})
//    @Severity(SeverityLevel.NORMAL)
//    @Step("User: Fullfil Checkout product")
//    @Description("Test case description: Click on the product to go to product detail page")
//    public void checkoutProduct(){
//        this.productPage.getProductDetailComponent().clickOnQuantityDropList();
//        this.productPage.getProductDetailComponent().clickOnRandomQuantityOption();
//        this.productPage.getProductDetailComponent().clickOnAddToCartButton();
//        this.productPage.getCheckoutComponent().isAt();
//    }

}
