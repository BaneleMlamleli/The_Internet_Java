package com.automation.StepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import com.automation.core.BaseClass;
public class Inputs extends BaseClass{
    
    
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("user clicks on Inputs")
    public void user_clicks_on_inputs() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Inputs']")).click();
    }

    @Then("user increase and decrease the numbers")
    public void user_increase_and_decrease_the_numbers() throws InterruptedException {
        for (int a = 0; a <= 5; a++) {
            webDriver.findElement(By.xpath("//input[@type='number']")).sendKeys(Integer.toString(a));
        }
    }
}
