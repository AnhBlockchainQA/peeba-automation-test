package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.LazyAutowired;
import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.service.UserActionService;
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
public class SuggestBrandsComponent extends BasePage {

    @LazyAutowired
    private UserActionService userActionService;


    @FindBy(xpath = "//h6[descendant::text()='Our picks for you']/../../following-sibling::div/div")
    private List<WebElement> suggestedBrands;

    private void waitUntilSuggestListLoaded(){
        await("Wait until list of suggested brand fully loaded").atMost(20, TimeUnit.SECONDS)
                .until(() -> this.suggestedBrands.size() == 8);
    }

    private WebElement filterBrandByName(String name){
        return suggestedBrands.stream()
                .map(element -> element.findElement(By.tagName("a")))
                .filter(el -> el.getAttribute("href").contains(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can not find brand with this name"));
    }
    /**
     *
     * @param name
     */
    public void clickOnSuggestBrandWithName(String name){
        waitUntilSuggestListLoaded();
        WebElement brand = filterBrandByName(name);
        userActionService.scrollToElement(brand);
        brand.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.suggestedBrands.size() > 0);
    }
}
