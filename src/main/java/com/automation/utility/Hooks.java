package com.automation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.core.BaseClass;

import io.cucumber.java.*;

public class Hooks extends BaseClass{
    @Before
    public void beforeMethodScenario() {
        System.out.println("This will run before the scenarios");
    }
    
    @After
    public void afterMethodScenario(Scenario sc) {
        System.out.println("This will run after the scenarios");
        if (sc.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", sc.getName());
        } else {
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", sc.getName());
        }
    }
}