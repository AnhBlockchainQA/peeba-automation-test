package com.peeba.test.e2etests.pages.checkout;

import com.google.common.util.concurrent.Uninterruptibles;
import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Log4j2
@PageFragment
public class CheckoutShippingAddressComponent extends BasePage {

    @FindBy(xpath = "//span[text()='Add Address']")
    private WebElement addAddressLink;

    @FindBy(xpath = "//label[text()='Contact name']/following-sibling::div/input")
    private WebElement contactNameInput;

    @FindBy(xpath = "//label[text()='Contact number']/following-sibling::div/div[contains(@class,'MuiSelect-select')]")
    private WebElement countryCodeDropList;

    @FindBy(css = "div[role='presentation'] .MuiMenu-paper ul li")
    private List<WebElement> optionsList;

    @FindBy(xpath = "//label[text()='Contact number']/../../../div[2]//input")
    private WebElement contactPhoneNumber;

    @FindBy(xpath = "//label[text()='Country']/following-sibling::div/div[contains(@class,'MuiSelect-select')]")
    private WebElement countryDropList;

    @FindBy(xpath = "//label[text()='Address']/following-sibling::div//input")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//label[text()='Address']/../../../../div[2]//input")
    private WebElement additionalAddressInput;

    @FindBy(xpath = "//label[text()='City']/following-sibling::div//input")
    private WebElement cityInput;

    @FindBy(xpath = "//label[text()='Province / State']/following-sibling::div//input")
    private WebElement stateInput;

    @FindBy(xpath = "//label[text()='Postal Code']/following-sibling::div//input")
    private WebElement postalCodeInput;

    private void inputContactName(String name) {
        log.info("Input {name} to contact name...", name);
        this.contactNameInput.sendKeys(name);
    }

    private void clickOnCountryCodeDropList() {
        log.info("Click on country code dropdown list...");
        actionService.clickOnElement(countryCodeDropList);
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    }

    private WebElement getRandomOptionToSelect() {
        log.info("Get any available option to click...");
        await("Wait until country code option list shown").atMost(10, TimeUnit.SECONDS)
                .until(() -> this.optionsList.size() >= 10);
        return this.optionsList.stream()
                .limit(10)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Country code options is null or empty"));
    }

    private void clickOnCountryCodeOption() {
        log.info("Click on country code option...");
        clickOnCountryCodeDropList();
        WebElement el = getRandomOptionToSelect();
        el.click();
    }

    private void inputContactPhoneNumber(String phoneNumber) {
        log.info("Input contact phone number ...");
        this.contactPhoneNumber.sendKeys(phoneNumber);
    }

    private void clickOnCountryDropList() {
        log.info("Click on country droplist...");
        actionService.clickOnElement(this.countryDropList);
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    }

    private void selectCountryOption() {
        log.info("Select country option...");
        clickOnCountryDropList();
        WebElement el = getRandomOptionToSelect();
        el.click();
    }

    private void inputMainAddress(String address) {
        log.info("Input {} to main address field...", address);
        this.streetAddressInput.sendKeys(address);
    }

    private void inputAdditionalAddress(String address) {
        log.info("Input {} to additional address field...", address);
        this.additionalAddressInput.sendKeys(address);
    }

    private void inputCity(String city) {
        log.info("Input {} into city field...", city);
        this.cityInput.sendKeys(city);
    }

    private void inputState(String state) {
        log.info("Input {} into state field...", state);
        this.stateInput.sendKeys(state);
    }

    private void inputPostalCode(String postalCode) {
        log.info("Input {} into zip code field...", postalCode);
        this.postalCodeInput.sendKeys(postalCode);
    }

    private void clickOnAddAddressLink() {
        log.info("Click on Add address link...");
        this.wait.until((d) -> this.addAddressLink.isDisplayed());
        this.addAddressLink.click();
    }

    /**
     * This method allows to fullfil shipping information form
     */
    public void fullfilShippingInformationForm() {
        log.info("Fullfiling shipping form...");
        clickOnAddAddressLink();
        inputContactName(faker.name().fullName());
        clickOnCountryCodeOption();
        inputContactPhoneNumber(faker.phoneNumber().phoneNumber());
        selectCountryOption();
        inputMainAddress(faker.address().streetAddress());
        inputAdditionalAddress(faker.address().secondaryAddress());
        inputCity(faker.address().cityName());
        inputState(faker.address().state());
        inputPostalCode(faker.address().zipCode());
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.countryDropList.isDisplayed());
    }
}
