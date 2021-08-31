package com.peeba.test.e2etests.pages.checkout;

import com.google.common.util.concurrent.Uninterruptibles;
import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

@PageFragment
@Log4j2
public class CheckoutProcessComponent extends BasePage {

    @FindBy(xpath = "//button[descendant::text()=\"Place order\"]")
    private WebElement placeOrderButton;

    @Autowired
    private UserActionService actionService;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.placeOrderButton.isDisplayed());
    }

    /**
     * This method aims to click on Place Order button
     */
    public void clickOnPlaceOrder() {
        log.info("Click on Place Order button...");
        this.wait.until((d) -> this.placeOrderButton.isEnabled());
        actionService.scrollToElement(this.placeOrderButton);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        this.placeOrderButton.click();
    }
}
