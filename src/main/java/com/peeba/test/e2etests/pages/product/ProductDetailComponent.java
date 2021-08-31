package com.peeba.test.e2etests.pages.product;

import com.google.common.util.concurrent.Uninterruptibles;
import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;

@PageFragment
public class ProductDetailComponent extends BasePage {

    @Autowired
    private UserActionService actionService;

    @FindBy(xpath = "(//h5)[2]")
    private WebElement productPrice;

    @FindBy(xpath = "//button[descendant::text()='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(css=".MuiFormControl-root .MuiInputBase-formControl .MuiSelect-selectMenu")
    private WebElement quantityDropList;

    @FindBy(css="#menu- .MuiPopover-paper ul li")
    private List<WebElement> quantityOptions;

    @FindBy(css="#root >div > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div > div.MuiBox-root:nth-child(2) h5")
    private WebElement productName;

    private void waitUntilAddToCartButtonEnabled(){
        await("Wait until Add to Cart button enabled").atMost(5, TimeUnit.SECONDS)
                .until(this.addToCartButton::isEnabled, is(true));
    }

    private void clickOnQuantityDropList(){
        actionService.clickOnElement(this.quantityDropList);
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    }

    private void waitUntilOptionsLoaded(){
        await("Wait until options to be fully loaded").atMost(10, TimeUnit.SECONDS)
                .until(() -> this.quantityOptions.size() >= 10);
    }

    private WebElement getRandomQuantityOption(float threshold){
        return this.quantityOptions.stream()
                .filter(el -> Float.valueOf(el.getText()
                        .split(" ")[2].replaceAll("\\)", "")
                        .replaceAll("\\+", "").replaceAll(",", "")) >= threshold)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Quantity options are not found or null"));
    }
    
    public void selectQuantityOptionForProduct(float threshold){
        waitUntilAddToCartButtonEnabled();
        clickOnQuantityDropList();
        waitUntilOptionsLoaded();
        WebElement element = getRandomQuantityOption(threshold);
        element.click();
    }

    public void clickOnAddToCartButton(){
        this.addToCartButton.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.addToCartButton.isDisplayed());
    }

    public void verifyProductNameCorrect(String name) {
        assertThat(this.productName.getText()).isEqualTo(name);
    }
}
