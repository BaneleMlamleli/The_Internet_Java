package com.automation.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class EntryAd  extends BaseClass {boolean modalDisplayed;

    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

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
