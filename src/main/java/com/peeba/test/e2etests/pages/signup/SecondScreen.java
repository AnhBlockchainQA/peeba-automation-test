package com.peeba.test.e2etests.pages.signup;

import com.peeba.test.e2etests.annotations.PageFragment;
import com.peeba.test.e2etests.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.FindBy;

@PageFragment
@Log4j2
public class SecondScreen extends BasePage {


    @Override
    public boolean isAt() {
        return true;
    }
}
