package com.peeba.test.e2etests.pages.signup;

import com.peeba.test.e2etests.annotations.Page;
import com.peeba.test.e2etests.pages.BasePage;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class SignUpPopup extends BasePage {

    @Autowired
    private FirstScreen firstScreen;

    public FirstScreen getFirstScreen(){
        return this.firstScreen;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
