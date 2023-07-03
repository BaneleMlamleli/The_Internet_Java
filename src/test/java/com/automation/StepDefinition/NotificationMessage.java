package com.automation.StepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class NotificationMessage {
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

    @When("user clicks on Notification Message")
    public void user_clicks_on_notification_message() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Notification Messages']")).click();
    }

    @Then("test all notification messages")
    public void test_all_notification_messages() {
        for (int i = 0; i <= 1; i++) {
            webDriver.findElement(By.xpath("//a[normalize-space()='Click here']")).click();
            new WebDriverWait(webDriver, Duration.ofSeconds(3));
            System.out.println("TEXT: " + webDriver.findElement(By.id("flash")).getText());
            if (webDriver.findElement(By.id("flash")).getText().equalsIgnoreCase("Action successful")) {
                System.out.println("'Action successful' is displayed");
            }else if (webDriver.findElement(By.id("flash")).getText().equalsIgnoreCase("Action unsuccesful, please try again")) {
                System.out.println("'Action unsuccesful, please try again' is displayed");
            }
        }
    }
}
