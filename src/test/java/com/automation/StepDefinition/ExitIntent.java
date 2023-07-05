package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.core.BaseClass;
import io.cucumber.java.en.*;
import java.time.Duration;

public class ExitIntent  extends BaseClass {Actions actions = null;

    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on Exit Intent")
    public void user_clicks_on_exit_intent() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Exit Intent']")).click();
    }
    
    @Then("move mouse out of the viewport pane and click on close button on the modal")
    public void move_mouse_out_of_the_viewport_pane_and_click_on_close_button_on_the_modal() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        
        actions = new Actions(webDriver);
        actions.moveByOffset(13, 15).perform();

        System.out.println("Model displayed: " + webDriver.findElement(By.xpath("//div[@class='modal']")).isDisplayed());
        
        webDriver.findElement(By.xpath("//p[normalize-space()='Close']")).click();
    }
}
