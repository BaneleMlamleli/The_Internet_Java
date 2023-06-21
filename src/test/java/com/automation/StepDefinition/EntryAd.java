package com.automation.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class EntryAd {
    WebDriver webDriver = null;
    boolean modalDisplayed;

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

    @When("user clicks on Entry Ad")
    public void user_clicks_on_entry_ad() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Entry Ad']")).click();
    }

    @And("check modal is display")
    public void check_modal_is_display() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
        
        System.out.println("Model displayed: " + webDriver.findElement(By.xpath("//div[@class='modal']")).isDisplayed());
        if (webDriver.findElement(By.xpath("//div[@class='modal']")).isDisplayed()) {
            modalDisplayed = true;
        } else {
            modalDisplayed = false;
        }
    }

    @And("to re-enable it click link")
    public void to_enable_it_click_link() {
        if (!modalDisplayed) {
            webDriver.findElement(By.xpath("//a[@id='restart-ad']")).click();   
        }
    }

    @Then("click on close button on the modal")
    public void click_on_close_button_on_the_modal() {
        webDriver.findElement(By.xpath("//p[normalize-space()='Close']")).click();
    }

}
