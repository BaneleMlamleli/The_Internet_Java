package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class DynamicallyLoading {
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

    @When("user clicks on Dynamically Loading")
    public void user_clicks_on_dynamically_loading() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Dynamic Loading']")).click();
    }

    @And("user clicks on example 1")
    public void user_clicks_on_example_1() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Example 1: Element on page that is hidden']")).click();
    }

    @And("user clicks on example 2")
    public void user_clicks_on_example_2() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Example 2: Element rendered after the fact']")).click();
    }

    @Then("start button is displayed and user clicks on the button")
    public void start_button_is_displayed_and_user_clicks_on_the_button() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
    }

    @And("waiting for loading counter")
    public void waiting_for_loading_counter() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (webDriver.findElement(By.xpath("//img[@src='/img/ajax-loader.gif']")).isDisplayed()) {
            System.out.println("Loading displayed");
        }
    }
    
    @And("Hello World is displayed")
    public void hello_world_is_displayed() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (webDriver.findElement(By.xpath("//h4[normalize-space()='Hello World!']")).getText().contains("Hello World!")) {
            System.out.println("Hello World! displayed. Successfully tested");
        }
    }
}
