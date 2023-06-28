package com.automation.StepDefinition;

import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class Hover {
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

    @When("user clicks on Hovers")
    public void user_clicks_on_hover() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Hovers']")).click();
    }

    @Then("user hovers on an image to display text below it")
    public void user_hovers_on_an_image_to_display_text_below_it() {
        actions = new Actions(webDriver);
        List<WebElement> images = webDriver.findElements(By.xpath("//div[@class='figure']/img[@src]"));
        for (WebElement webElementImages : images) {
            actions.moveToElement(webElementImages.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"))).perform();
            System.out.println("Image attribute: " + webElementImages.getAttribute("outerHTML"));
        }
    }
}
