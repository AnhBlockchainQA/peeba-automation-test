package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;
import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@PageFragment
public class ProductBrandComponent extends BasePage {

    @FindBy(tagName = "h5")
    private WebElement brandName;

    @FindBy(css=".MuiGrid-root .MuiGrid-item > .MuiBox-root")
    private List<WebElement> brandProducts;

    @FindBy(css="svg.MuiCircularProgress-svg")
    private WebElement loadingIcon;

    @FindBy(xpath="//p[text()=\"Price\"]")
    private WebElement priceSortLabel;

    @Autowired
    private UserActionService userActionService;

    private void waitUntilProductsListLoaded(){
        await("Wait until loading icon not shown").atMost(10, TimeUnit.SECONDS)
                .until(() -> this.brandProducts.size() > 5);
    }

    private void scrollToPriceSortSection(){
        userActionService.scrollToElement(this.priceSortLabel);
    }


    public void clickOnRandomProduct(String name){
        scrollToPriceSortSection();
        waitUntilProductsListLoaded();
        this.brandProducts.stream()
                .map(el -> el.findElement(By.cssSelector("div.MuiBox-root > a[href*='" + name + "']")))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Brand products list is empty or null"))
                .click();
    }


    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.brandName.isDisplayed());
    }
}
