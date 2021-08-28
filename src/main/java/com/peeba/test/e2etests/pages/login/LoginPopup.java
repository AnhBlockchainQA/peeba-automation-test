package com.peeba.test.e2etests.pages.login;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class LoginPopup extends BasePage {

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiDialog-container')]//input[@type='text']")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[contains(@class, 'MuiDialog-container')]//input[@type='password']")
    private WebElement password;

    public void clickOnLoginButton(){
        this.loginButton.click();
    }

    public void inputEmail(String email){
        this.emailAddress.sendKeys(email);
    }

    public void inputPassword(String password){
        this.password.sendKeys(password);
    }

    public void login(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.loginButton.isDisplayed());
    }
}
