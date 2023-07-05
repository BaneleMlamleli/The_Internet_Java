package com.automation.StepDefinition;

import org.openqa.selenium.By;
import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class DisappearingElements extends BaseClass{
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on disappearing elements")
    public void user_clicks_on_disappearing_elements() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Disappearing Elements']")).click();
    }

    @Then("check all elements are present")
    public void check_all_elements_are_present() {
        // There has to be a better way of doing this than using IF conditions
        
        if (webDriver.findElement(By.xpath("//a[normalize-space()='Home']")).isDisplayed()) {
            System.out.println("'Home' tab element is appearing");
        } else {
            System.out.println("'Home' tab element is not appearing");
        }

        if (webDriver.findElement(By.xpath("//a[normalize-space()='About']")).isDisplayed()) {
            System.out.println("'About' tab element is appearing");
        } else {
            System.out.println("'About' tab element is not appearing");
        }

        if (webDriver.findElement(By.xpath("//a[normalize-space()='Contact Us']")).isDisplayed()) {
            System.out.println("'Contact Us' tab element is appearing");
        } else {
            System.out.println("'Contact Us' tab element is not appearing");
        }
        
        if (webDriver.findElement(By.xpath("//a[normalize-space()='Portfolio']")).isDisplayed()) {
            System.out.println("'Portfolio' tab element is appearing");
        } else {
            System.out.println("'Portfolio' tab element is not appearing");
        }

        if (webDriver.findElement(By.xpath("//a[normalize-space()='Gallery']")).isDisplayed()) {
            System.out.println("'Gallery' tab element is appearing");
        } else {
            System.out.println("'Gallery' tab element is not appearing");
        }
    }
}
