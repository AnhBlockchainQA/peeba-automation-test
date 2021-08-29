package com.peeba.test.e2etests.pages.product;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class ProductPage extends BasePage {

    @Autowired
    private ProductBrandComponent productBrandComponent;

    @Autowired
    private ProductDetailComponent productDetailComponent;

    @Autowired
    private SuggestBrandsComponent suggestBrandsComponent;

    @Autowired
    private ProductCheckoutComponent checkoutComponent;

    public ProductBrandComponent getProductBrandComponent(){
        return productBrandComponent;
    }

    public ProductDetailComponent getProductDetailComponent(){
        return productDetailComponent;
    }

    public SuggestBrandsComponent getSuggestBrandsComponent(){
        return this.suggestBrandsComponent;
    }

    public ProductCheckoutComponent getCheckoutComponent(){
        return this.checkoutComponent;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
