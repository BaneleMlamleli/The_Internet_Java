package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class BrokenImages extends BaseClass{    
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

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
