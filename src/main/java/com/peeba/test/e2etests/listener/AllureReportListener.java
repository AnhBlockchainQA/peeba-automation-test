package com.peeba.test.e2etests.listener;

import com.peeba.test.e2etests.service.ScreenshotService;
import io.qameta.allure.Allure;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.internal.IResultListener2;

import java.io.ByteArrayInputStream;
import java.time.Instant;

public class AllureReportListener extends TestListenerAdapter {

    @Autowired
    public ScreenshotService screenshotService;

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        Allure.attachment(iTestResult.getTestContext().getName() + "_" + Instant.now(),
                new ByteArrayInputStream(this.screenshotService.getScreenshot()));
    }
}
