package com.peeba.test.e2etests.pages.product;

import com.google.common.util.concurrent.Uninterruptibles;
import com.peeba.test.e2etests.annotations.LazyAutowired;
import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import static org.awaitility.Awaitility.*;
import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@PageFragment
@Log4j2
public class SuggestBrandsComponent extends BasePage {

    @LazyAutowired
    private UserActionService userActionService;


    @FindBy(xpath = "//h6[descendant::text()='Our picks for you']/../../following-sibling::div/div/a")
    private List<WebElement> suggestedBrands;

    private void waitUntilSuggestListLoaded() {
        await("Wait until list of suggested brand fully loaded").atMost(20, TimeUnit.SECONDS)
                .until(() -> this.suggestedBrands.size() == 8);
    }

    private WebElement filterBrandByName(String name) {
        log.info("Find the brand with name {} in suggested brands list...", name);
        return this.suggestedBrands.stream()
                .filter(el -> el.getAttribute("href").contains(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can not find brand with this name"));
    }

    private void clickOnBrandName(WebElement brand) {
        this.wait.until((d) -> brand.isEnabled());
        brand.click();
    }

    /**
     * Click on suggest brand with name
     *
     * @param name
     */
    public void clickOnSuggestBrandWithName(String name) {
        waitUntilSuggestListLoaded();
        WebElement brand = filterBrandByName(name);
        clickOnBrandName(brand);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.suggestedBrands.size() > 0);
    }
}
