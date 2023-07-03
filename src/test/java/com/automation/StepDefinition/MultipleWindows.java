package com.automation.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class MultipleWindows {
    WebDriver webDriver = null;
    WebDriverWait wait = null;
    
    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
    //     webDriver = new ChromeDriver();
    //     webDriver.manage().window().maximize();
    //     webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
    //     try {
    //         Thread.sleep(2000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    @When("user clicks on Multiple Windows")
    public void user_clicks_on_multiple_windows() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Multiple Windows']")).click();
    }
    
    @Then("open new window and confirm new window is opened")
    public void open_new_window_and_confirm_new_window_is_opened() {
        //Store the ID of the original window
        String originalWindow = webDriver.getWindowHandle();

        //Check we don't have other windows open already
        // assert webDriver.getWindowHandles().size() == 1;

        //Click the link which opens in a new window
        webDriver.findElement(By.linkText("Click Here")).click();

        //Wait for the new window or tab
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
        
        if (webDriver.findElement(By.xpath("//h3[normalize-space()='New Window']")).isDisplayed()) {
            System.out.println("Test passed. New window opened and confirmed");
        }
    }
}
