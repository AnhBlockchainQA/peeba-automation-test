package com.peeba.test.e2etests.pages.checkout;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class CheckoutPage extends BasePage {

    @Autowired
    private CheckoutShippingAddressComponent shippingAddressComponent;

    @Autowired
    private CheckoutPaymentComponent paymentComponent;

    @Autowired
    private CheckoutProcessComponent checkoutProcessComponent;

    @Autowired
    private CheckoutConfirmationComponent checkoutConfirmationComponent;

    public CheckoutShippingAddressComponent getShippingAddressComponent(){
        return this.shippingAddressComponent;
    }

    public CheckoutPaymentComponent getPaymentComponent(){
        return this.paymentComponent;
    }

    public CheckoutProcessComponent getConfirmationComponent(){
        return this.checkoutProcessComponent;
    }

    public CheckoutConfirmationComponent getCheckoutConfirmationComponent() {
        return checkoutConfirmationComponent;
    }

    @Override
    public boolean isAt() {
        return this.checkoutProcessComponent.isAt();
    }
}
