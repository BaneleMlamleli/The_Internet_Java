package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class DisappearingElements {
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
