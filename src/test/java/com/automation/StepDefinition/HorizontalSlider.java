package com.automation.StepDefinition;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class HorizontalSlider {
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

    @When("user clicks on Horizontal Slider")
    public void user_clicks_on_horizontal_slider() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Horizontal Slider']")).click();
    }

    @Then("user pushes the slider up and down")
    public void user_pushes_the_slider_up_and_down() {
        WebElement slider = webDriver.findElement(By.xpath("//div[@class='sliderContainer']/input[@type='range']"));
        new Actions(webDriver).dragAndDropBy(slider, 40, 0).perform();
    }
}
