package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
@Log4j2
public class ProductCheckoutComponent extends BasePage {

    @FindBy(xpath = "//button[descendant::text()='Checkout']")
    private WebElement checkoutButton;

    public void clickOnCheckoutButton(){
        log.info("Click on Checkout button");
        this.checkoutButton.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.checkoutButton.isDisplayed());
    }

}
