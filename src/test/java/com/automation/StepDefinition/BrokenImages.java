package com.automation.StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class BrokenImages {
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

    @When("user clicks on broken images")
    public void user_clicks_on_broken_images() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Broken Images']")).click();
    }

    @Then("check images")
    public void check_images() {
        for (WebElement image : webDriver.findElements(By.cssSelector("img"))) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println(image.getAttribute("outerHTML") + " is broken.");
            }
        }
    }
}
