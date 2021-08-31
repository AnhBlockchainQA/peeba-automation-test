package com.peeba.test.e2etests.pages.home;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@PageFragment
public class HeaderComponent extends BasePage {

    @FindBy(css = "header .MuiToolbar-dense .MuiContainer-maxWidthLg .MuiCollapse-entered input")
    private WebElement searchBox;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(css = "header .MuiToolbar-dense .MuiContainer-maxWidthLg .MuiCollapse-entered button")
    private WebElement signUpButton;

    @FindBy(css = "button img[src*='user.svg']")
    private WebElement userAvatarIcon;

    @FindBy(css = "header > .MuiBox-root a")
    private List<WebElement> categories;

    @FindBy(css = "div[role=\"presentation\"] > div.MuiPopover-paper > div:nth-child(1) > div > p")
    private WebElement username;

    @Override
    public boolean isAt() {
        log.info("Verify if we is at the header component...");
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }

    /**
     * Click on Login n
     */
    public void clickOnLoginLink() {
        log.info("Click on Login link...");
        this.loginLink.click();
    }

    /**
     * Click on the Sign up button
     */
    public void clickOnSignUpButton() {
        log.info("Click on Sign up button...");
        this.signUpButton.click();
    }

    /**
     * Click on the category with name
     *
     * @param name
     */
    public void clickOnCategoryWithName(String name) {
        this.categories.stream()
                .filter(el -> el.getText().equals(name))
                .findFirst().orElseThrow(() -> {
            throw new RuntimeException("Category with name not found");
        }).click();
    }

    /**
     * Verify that we login successful
     *
     * @param userName
     */
    public void verifyLoginSuccessful(String userName) {
        assertThat(this.username.getText()).isEqualTo(userName);
    }

    /**
     * Click on user avatar icon
     */
    public void clickOnUserAvatarIcon() {
        this.wait.until((d) -> this.userAvatarIcon.isDisplayed());
        this.userAvatarIcon.click();
    }
}
