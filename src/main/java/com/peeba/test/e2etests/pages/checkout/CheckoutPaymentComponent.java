package com.peeba.test.e2etests.pages.checkout;

import com.github.javafaker.Faker;
import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.constants.RegexConstants;
import com.peeba.test.e2etests.constants.StripeCardNumber;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.IframeSwitchService;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageFragment
@Log4j2
public class CheckoutPaymentComponent extends BasePage {

    @Autowired
    private IframeSwitchService iframeSwitchService;

    @Autowired
    private Faker faker;

    @FindBy(xpath = "//span[text()='Add payment method']")
    private WebElement addPaymentMethodLink;

    @FindBy(xpath = "//span[text()='Cardholder name']/following-sibling::div//input")
    private WebElement cardHolderInput;

    @FindBy(xpath = "//span[text()='Card information']/following-sibling::div//iframe[contains(@name,\"__privateStripeFrame\")]")
    private WebElement cardInfoFrame;

    @FindBy(name="cardnumber")
    private WebElement cardNumberInput;

    @FindBy(name="exp-date")
    private WebElement expiryDateInput;

    @FindBy(name="cvc")
    private WebElement cvcInput;

    @FindBy(name="postal")
    private WebElement zipCodeInput;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.cardHolderInput.isDisplayed());
    }

    private void inputCardholderName(String name){
        log.info("Input {} into cardholder name...", name);
        this.wait.until((d) -> this.cardHolderInput.isDisplayed());
        this.cardHolderInput.sendKeys(name);
    }

    private void switchToCardInfoFrame(){
        log.info("Switch to frame...");
        iframeSwitchService.switchToFrameWithSelector(cardInfoFrame);
    }

    private void inputCardNumber(String number){
        log.info("Input {} into card number field...", number);
        this.cardNumberInput.sendKeys(number);
    }

    private void inputExpiryDate(String date){
        log.info("Input {} into expiry date field...", date);
        this.expiryDateInput.sendKeys(date);
    }

    private void inputCvc(String number){
        log.info("Input {} into CVC field...", number);
        this.cvcInput.sendKeys(number);
    }

    private void inputZipCode(String code){
        log.info("Input {} into zip code field...", code);
        this.zipCodeInput.sendKeys(code);
    }

    private void clickOnAddPaymentMethodLink(){
        log.info("Click on Add payment link...");
        this.wait.until((d) -> this.addPaymentMethodLink.isDisplayed());
        this.addPaymentMethodLink.click();
    }

    /**
     * This method helps to fullfil card information form
     */
    public void fullfilCardInformationForm() {
        clickOnAddPaymentMethodLink();
        inputCardholderName(faker.name().firstName().toUpperCase() + " " + faker.name().lastName().toUpperCase());
        switchToCardInfoFrame();
        inputCardNumber(StripeCardNumber.randomCardNumber().getCardNumber());
        inputExpiryDate(faker.regexify(RegexConstants.EXPIRY_DATE_REGEX.getRegEx()));
        inputCvc(String.valueOf(faker.random().nextInt(100,999)));
        inputZipCode(faker.regexify(RegexConstants.ZIP_CODE_REGEX.getRegEx()));
    }
}
