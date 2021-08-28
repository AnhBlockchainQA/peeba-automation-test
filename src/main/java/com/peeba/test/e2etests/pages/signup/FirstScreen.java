package com.peeba.test.e2etests.pages.signup;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
public class FirstScreen extends BasePage {

    @FindBy(xpath = "//div[@role='presentation']//h6")
    private WebElement signUpLabel;

    @FindBy(xpath = "//div[@role='presentation']//input[@type='text']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@role='presentation']//span[text()='Sign up']")
    private WebElement signUpButton;

    public void inputSignUpEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void clickSignUpButton(){
        this.signUpButton.click();
    }

    public void signUp(String email){
        inputSignUpEmail(email);
        clickSignUpButton();
    }


    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.signUpLabel.isDisplayed());
    }
}
