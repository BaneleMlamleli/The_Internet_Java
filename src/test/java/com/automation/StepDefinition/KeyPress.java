package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class KeyPress {
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
