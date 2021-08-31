package com.peeba.test.e2etests.pages.checkout;

import com.google.common.util.concurrent.Uninterruptibles;
import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.constants.ApplicationMessage;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Page
@Log4j2
public class CheckoutConfirmationComponent extends BasePage {

    @FindBy(css="img[src*='placeOrderTick.svg']")
    private WebElement orderConfirmationTick;

    @FindBy(tagName = "h5")
    private WebElement message;

    /**
     * This method verifies if confirmation message is present
     */
    public void verifyConfirmationMessagePresent(){
        log.info("Waiting and check if confirmation message is shown...");
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        assertThat(this.message.getText()).isEqualTo(ApplicationMessage.ORDER_CONFIRMATION_MESSAGE.getMessage());
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
