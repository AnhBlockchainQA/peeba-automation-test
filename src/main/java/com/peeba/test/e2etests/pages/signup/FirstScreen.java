package com.peeba.test.e2etests.pages.signup;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.constants.RegexConstants;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
@Log4j2
public class FirstScreen extends BasePage {

    @FindBy(xpath = "//div[@role='presentation']//h6")
    private WebElement signUpLabel;

    @FindBy(xpath = "//div[@role='presentation']//input[@type='text']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@role='presentation']//span[text()='Sign up']")
    private WebElement signUpButton;

    private void inputSignUpEmail(String email) {
        log.info("Input {} into email input field...", email);
        this.emailInput.sendKeys(email);
    }

    private void clickSignUpButton() {
        log.info("Click on sign up button...");
        this.signUpButton.click();
    }

    /**
     * Sign up new email
     */
    public void signUp() {
        inputSignUpEmail(faker.bothify("??????##@1secmail.com"));
        clickSignUpButton();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.signUpLabel.isDisplayed());
    }
}
