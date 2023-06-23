package com.automation.StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class FloatingMenu {
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

    @When("user clicks on Floating Menu")
    public void user_clicks_on_floating_menu() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Floating Menu']")).click();
    }

    @Then("user clicks on the individual menu tabs")
    public void user_clicks_on_the_individual_menu_tabs() {
        List<WebElement> listOfMenuElements = webDriver.findElements(By.xpath("//a"));
        for (WebElement webElement : listOfMenuElements) {
            switch (webElement.getText()) {
                case "Home":
                    webDriver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
                    if (webDriver.getCurrentUrl()
                            .equalsIgnoreCase("https://the-internet.kineticskunk.co.za/floating_menu#home")) {
                        System.out.println("'Home' button clicked. Test passed!");
                    }break;
                case "News":
                    webDriver.findElement(By.xpath("//a[normalize-space()='News']")).click();
                    if (webDriver.getCurrentUrl()
                            .equalsIgnoreCase("https://the-internet.kineticskunk.co.za/floating_menu#news")) {
                        System.out.println("'News' button clicked. Test passed!");
                    }break;
                case "Contact":
                    webDriver.findElement(By.xpath("//a[normalize-space()='Contact']")).click();
                    if (webDriver.getCurrentUrl()
                            .equalsIgnoreCase("https://the-internet.kineticskunk.co.za/floating_menu#contact")) {
                        System.out.println("'Contact' button clicked. Test passed!");
                    }break;
                case "About":
                    webDriver.findElement(By.xpath("//a[normalize-space()='About']")).click();
                    if (webDriver.getCurrentUrl()
                            .equalsIgnoreCase("https://the-internet.kineticskunk.co.za/floating_menu#about")) {
                        System.out.println("'About' button clicked. Test passed!");
                    }break;
            }
        }

    }
}
