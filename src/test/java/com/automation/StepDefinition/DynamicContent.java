package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicContent {
    WebDriver webDriver = null;
    Actions actions = null;

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
