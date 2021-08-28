package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.processor.MenuBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class ProductComponent extends BasePage {

    @FindBy(xpath = "//h6[descendant::text()='Our picks for you']/../../following-sibling::div/div")
    private List<WebElement> suggestedBrands;


    @FindBy(css = "div.MuiTabs-root .MuiTabs-scroller button")
    private List<WebElement> menuTabBar;

    @FindBy(css = "div.MuiGrid-item")
    private List<WebElement> products;

    public void clickOnSuggestBrandWithName(String name){
        
    }

    public void clickOnRandomProduct(){
        products.stream().map(el -> el.findElement(By.tagName("a")))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product has no link and/or no product is found"))
                .click();
    }


    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.menuTabBar.stream().anyMatch(
                el -> el.getText().equals(MenuBar.PRODUCT.getTabName())
        ));
    }
}
