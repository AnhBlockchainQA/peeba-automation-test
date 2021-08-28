package com.peeba.test.e2etests.aop;


import com.peeba.test.e2etests.annotations.Window;
import com.peeba.test.e2etests.service.WindowSwitchService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.peeba.test.e2etests..*)")
    //Take class which has annotation called Window and this class is presented in this
    // before execution of each method, run this
    public void before(Window window){
        this.switchService.switchByTitle(window.value());
    }

    //This will be execute after each method execution
    public void after(Window window){
        this.switchService.switchByIndex(0);
    }

}


