package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class ProductShippingComponent extends BasePage {

    @FindBy(xpath="//label[text()='Contact name']/following-sibling::div/input")
    private WebElement contactNameInput;

    @FindBy(xpath="//label[text()='Contact number']/following-sibling::div/div[contains(@class,'MuiSelect-select')]")
    private WebElement countryCodeDropList;

    @FindBy(xpath="//label[text()='Contact number']/../../../div[2]//input")
    private WebElement contactPhoneNumber;

    @FindBy(xpath="//label[text()='Address']/following-sibling::div//input")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//label[text()='Address']/../../../../div[2]//input")
    private WebElement additionalAddressInput;

    @FindBy(xpath = "//label[text()='City']/following-sibling::div//input")
    private WebElement cityInput;

    @FindBy(xpath = "//label[text()='Province / State']/following-sibling::div//input")
    private WebElement stateInput;

    @FindBy(xpath = "//label[text()='Postal Code']/following-sibling::div//input")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//span[text()='Cardholder name']/following-sibling::div//input")
    private WebElement cardHolderInput;

    @FindBy(xpath = "//span[text()='Card information']/following-sibling::div//iframe[contains(@name,\"__privateStripeFrame\")]")
    private WebElement cardInfoFrame;

    @FindBy(name="cardnumber")
    private WebElement cardNumber;

    @FindBy(name="exp-date")
    private WebElement expiryDate;

    @FindBy(name="cvc")
    private WebElement cvc;

    @FindBy(name="postal")
    private WebElement zipCode;

    @FindBy(xpath = "//button[descendant::text()=\"Place order\"]")
    private WebElement placeOrderButton;

    public void inputContactName(String name){
        this.contactNameInput.sendKeys(name);
    }

    public void inputContactPhoneNumber(String phoneNumber){
        this.contactPhoneNumber.sendKeys(phoneNumber);
    }


    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.placeOrderButton.isDisplayed());
    }
}
