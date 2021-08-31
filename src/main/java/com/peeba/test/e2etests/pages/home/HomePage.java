package com.peeba.test.e2etests.pages.home;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import com.peeba.test.e2etests.pages.product.SuggestBrandsComponent;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
@Page
public class HomePage extends BasePage {

    @Autowired
    private HeaderComponent headerComponent;

    /**
     * Go to url
     * @param url
     */
    public void goTo(String url){
        log.info("Go to the link {url}...", url);
        this.driver.get(url);
    }

    public HeaderComponent getHeaderComponent(){
        return headerComponent;
    }

    @Override
    public boolean isAt() {
        return this.headerComponent.isAt();
    }
}
