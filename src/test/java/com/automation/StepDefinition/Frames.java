package com.automation.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class Frames {
    WebDriver webDriver = null;

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user clicks on Frames")
    public void user_clicks_on_frames() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Frames']")).click();
    }

    @Then("user clicks on Nested Frames")
    public void user_user_clicks_on_nested_frames() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
    }

    @And("confirm all frames are displayed")
    public void confirm_all_frames_are_displayed() {
        // Switching to the top frame
        webDriver.switchTo().frame("frame-top");
        boolean frameLeft = webDriver.findElement(By.xpath("//frame[@src='/frame_left']")).isDisplayed();
        System.out.println("frame-left: " + frameLeft);
        
        boolean frameMiddle = webDriver.findElement(By.xpath("//frame[@src='/frame_middle']")).isDisplayed();
        System.out.println("frame-middle: " + frameMiddle);
        
        boolean frameRight = webDriver.findElement(By.xpath("//frame[@src='/frame_right']")).isDisplayed();
        System.out.println("frame-right: " + frameRight);

        // Return to the top level
        webDriver.switchTo().parentFrame(); //.defaultContent();

        // Switching to the bottom frame
        webDriver.switchTo().frame("frame-bottom");
        boolean frameBottom = webDriver.findElement(By.xpath("//frame[@name='frame-bottom']")).isDisplayed();
        System.out.println("frame-bottom: " + frameBottom);
    }
}
