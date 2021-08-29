package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageFragment
public class ProductDetailComponent extends BasePage {

    @Autowired
    private UserActionService actionService;

    @FindBy(xpath = "//button[descendant::text()='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(css=".MuiFormControl-root .MuiInputBase-formControl .MuiSelect-selectMenu")
    private WebElement quantityDropList;

    @FindBy(css="#menu- .MuiPopover-paper ul li")
    private List<WebElement> quantityOptions;

    public void clickOnQuantityDropList(){
        actionService.clickOnElement(quantityDropList);
    }

    public void clickOnRandomQuantityOption(){
        quantityOptions.stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Quantity options are not found or null"))
                .click();
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.addToCartButton.isDisplayed());
    }
}
