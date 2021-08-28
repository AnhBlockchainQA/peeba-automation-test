package com.peeba.test.e2etests.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Calendar;

@Service
public class ScreenshotService {

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenshot() throws IOException {
        File sourceFile = ((TakesScreenshot) this.ctx.getBean(TakesScreenshot.class)).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve("screenshot_" + Calendar.getInstance() + ".png").toFile());
    }

    public byte[] getScreenshot(){
        return ((TakesScreenshot) this.ctx.getBean(TakesScreenshot.class)).getScreenshotAs(OutputType.BYTES);
    }
    
}
