package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JavaScriptOnloadEventError {
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

    @When("user clicks on JavaScript Onload Event Error")
    public void user_clicks_on_JavaScript_Onload_Event_Error() {
        webDriver.findElement(By.xpath("//a[normalize-space()='JavaScript onload event error']")).click();
    }

    @Then("Confirm onload event error")
    public void confirm_onload_event_error() {
        if (webDriver.findElement(By.xpath("//p[contains(text(),'This page has a JavaScript error in the onload event.')]")).isDisplayed()) {
            System.out.println("Onload Event test passed");
        }
    }
}
