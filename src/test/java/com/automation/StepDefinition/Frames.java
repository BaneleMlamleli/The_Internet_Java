package com.automation.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Frames {
    WebDriver webDriver = null;

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
        webDriver.switchTo().parentFrame();

        // Switching to the bottom frame
        webDriver.switchTo().frame(1);
        //body
        System.out.println("Text of bottom frame: " + webDriver.findElement(By.tagName("body")).getText());
        boolean frameBottom = webDriver.findElement(By.tagName("body")).isDisplayed();
        System.out.println("frame-bottom: " + frameBottom);
    }
    
    @Then("user clicks on iFrames and confirms iframe is displayed")
    public void user_clicks_on_iFrames_and_confirms_iframe_is_displayed() {
        webDriver.findElement(By.xpath("//a[normalize-space()='iFrame']")).click();
        webDriver.switchTo().frame("mce_0_ifr");
        boolean iFrame = webDriver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).isDisplayed();
        System.out.println("iFrame: " + iFrame + ", iFrame text: " + webDriver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).getText());
    }
}
