package com.peeba.test.e2etests.pages.login;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
@Page
public class LoginPopup extends BasePage {

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiDialog-container')]//input[@type='text']")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[contains(@class, 'MuiDialog-container')]//input[@type='password']")
    private WebElement password;

    private void clickOnLoginButton(){
        this.loginButton.click();
    }

    private void inputEmail(String email){
        this.emailAddress.sendKeys(email);
    }

    private void inputPassword(String password){
        this.password.sendKeys(password);
    }

    /**
     * This method aims to login to the app
     * @param email
     * @param password
     */
    public void login(String email, String password){
        log.info("Login with {}/{}", email, password);
        inputEmail(email);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.loginButton.isDisplayed());
    }
}
