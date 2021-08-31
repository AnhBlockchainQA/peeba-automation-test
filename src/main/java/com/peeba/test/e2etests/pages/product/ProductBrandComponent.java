package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.constants.RegexConstants;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.awaitility.Awaitility.*;
import static org.assertj.core.api.Assertions.assertThat;


@PageFragment
@Log4j2
public class ProductBrandComponent extends BasePage {

    @FindBy(tagName = "h5")
    private WebElement brandName;

    @FindBy(css = ".MuiGrid-root .MuiGrid-item > .MuiBox-root > div.MuiBox-root > a")
    private List<WebElement> brandProducts;

    @FindBy(css = "svg.MuiCircularProgress-svg")
    private WebElement loadingIcon;

    @FindBy(xpath = "//p[text()=\"Price\"]")
    private WebElement priceSortLabel;

    @FindBy(xpath = "//img[contains(@src,'investment')]/../span")
    private WebElement investmentThreshold;

    @Autowired
    private UserActionService userActionService;

    private void waitUntilProductsListLoaded() {
        await("Wait until loading icon not shown").atMost(15, TimeUnit.SECONDS)
                .until(() -> this.brandProducts.size() >= 20);
    }

    private void scrollToPriceSortSection() {
        log.info("Scroll to price sort section...");
        userActionService.scrollToElement(this.priceSortLabel);
    }

    private WebElement selectRandomProductOfBrand() {
        log.info("Select any available product of the brand...");
        return this.brandProducts.stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Brand products list is empty or null"));
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.brandName.isDisplayed());
    }

    /**
     * Click on any product of brand
     */
    public void clickOnRandomProductOfBrand() {
        scrollToPriceSortSection();
        waitUntilProductsListLoaded();
        selectRandomProductOfBrand().click();
    }

    /**
     * Verify that the brand name displayed correctly
     *
     * @param brand
     */
    public void verifyBrandNameDisplayedCorrectly(String brand) {
        log.info("Verify if brand name displayed is correct");
        assertThat(this.brandName.getText()).isEqualTo(brand);
    }

    /**
     * Get the thereshold of the brand
     *
     * @return float
     */
    public float getThresholdOfBrand() {
        Pattern p = Pattern.compile(RegexConstants.AMOUNT_REGEX.getRegEx());
        Matcher m = p.matcher(this.investmentThreshold.getText());
        if (m.find())
            return Float.valueOf(m.group(0).replace(",", ""));
        else
            return -1f;
    }
}
