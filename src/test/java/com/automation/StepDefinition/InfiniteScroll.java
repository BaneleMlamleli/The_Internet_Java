package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InfiniteScroll {
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

    @When("user clicks on Infinite Scroll")
    public void user_clicks_on_infinite_scroll() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Infinite Scroll']")).click();
    }

    @Then("confirm infinite scrolling")
    public void confirm_infinite_scrolling() {
        boolean confirmDisplay = webDriver.findElement(By.xpath("//h3[normalize-space()='Infinite Scroll']")).isDisplayed();
        if (confirmDisplay) {
            System.out.println("Infinite scrolling confirmed. Test passed");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        webDriver.close();
        webDriver.quit();
    }
}
