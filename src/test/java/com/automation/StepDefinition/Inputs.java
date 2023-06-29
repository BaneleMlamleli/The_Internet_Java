package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Inputs {
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
