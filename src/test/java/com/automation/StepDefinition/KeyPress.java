package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class KeyPress  extends BaseClass {
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on Key Press")
    public void user_clicks_on_key_press() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Key Presses']")).click();
    }

    @Then("user presses any keyboard buttons")
    public void user_presses_any_keyboard_buttons() {
        WebElement textField = webDriver.findElement(By.xpath("//input[@id='target']"));
        // new Actions(webDriver).keyDown(Keys.SHIFT).sendKeys(textField, "up").perform();
        new Actions(webDriver).sendKeys(textField, "\\uE01A").perform();
    }
}
