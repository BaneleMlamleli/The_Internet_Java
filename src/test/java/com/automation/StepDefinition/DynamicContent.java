package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class DynamicContent extends BaseClass{

    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on dynamic content")
    public void user_clicks_on_dynamic_content() {
        double randomNumber = 1 + (Math.random() * 5); // random number to make the selection a bit dynamic
        if (randomNumber > 3) {
            // dynamic content
            webDriver.findElement(By.xpath("//a[normalize-space()='Dynamic Content']")).click(); 
        } else {
            // This is launching the static page to make some of the content static
            webDriver.get("https://the-internet.kineticskunk.co.za/dynamic_content?with_content=static");           
        }
    }

    @Then("check images and text change")
    public void check_images() {
        for (WebElement image : webDriver.findElements(By.cssSelector("img"))) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println(image.getAttribute("outerHTML") + " is broken.");
            } else {
                System.out.println("Visible image: " + image.getAttribute("outerHTML"));
            }
        }
    }
}
