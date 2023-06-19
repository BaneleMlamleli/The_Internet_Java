package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class ContextMenu {
    WebDriver webDriver = null;
    Actions action = null;

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

    @When("user clicks on Context Menu")
    public void user_clicks_on_context_menu() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Context Menu']")).click();
    }

    @And("user right-click on the box")
    public void user_right_click_on_the_box() {
        action = new Actions(webDriver);
        action.contextClick(webDriver.findElement(By.xpath("//div[@id='hot-spot']"))).perform();
    }

    @Then("JavaScript alert is displayed")
    public void javascript_alert_is_displayed() {
        webDriver.switchTo().alert();
    }

    @And("user clicks okay on the JavaScript alert button")
    public void user_clicks_okay_on_the_JavaScript_alert_button() {
        webDriver.switchTo().alert().accept();
    }
}