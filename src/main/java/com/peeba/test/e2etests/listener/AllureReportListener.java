package com.peeba.test.e2etests.listener;

import com.peeba.test.e2etests.service.BeanUtil;
import com.peeba.test.e2etests.service.ScreenshotService;
import io.qameta.allure.Allure;
import org.springframework.stereotype.Component;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.ByteArrayInputStream;
import java.time.Instant;

@Component
public class AllureReportListener extends TestListenerAdapter {

    @Override
    public synchronized void onTestFailure(ITestResult iTestResult) {
        ScreenshotService screenshotService = BeanUtil.getBean(ScreenshotService.class);
        Allure.attachment(iTestResult.getTestContext().getName() + "_" + Instant.now(),
                    new ByteArrayInputStream(screenshotService.getScreenshot()));
    }
}
