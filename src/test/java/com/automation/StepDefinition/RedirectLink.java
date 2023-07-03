package com.automation.StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class RedirectLink {
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

    @When("user clicks on Redirect Link")
    public void user_clicks_on_redirect_link() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Redirect Link']")).click();
    }

    @And("user clicks link to trigger the redirect")
    public void user_clicks_link_to_trigger_the_redirect() {
        webDriver.findElement(By.xpath("//a[@id='redirect']")).click();
    }

    @Then("test listed status codes")
    public void test_listed_status_codes() {
        try {
            List<WebElement> listOfHrefLinkElements = webDriver.findElements(By.xpath("//ul//a[@href]"));
            for (WebElement hrefLinkElements : listOfHrefLinkElements) {
                System.out.println(hrefLinkElements.getText());
                switch (hrefLinkElements.getText()) {
                    case "200":
                        webDriver.findElement(By.xpath("//a[normalize-space()='200']")).click();
                        if (webDriver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]")).isDisplayed()) {
                            System.out.println("This page returned a 200 status code.");
                        }
                        break;            
                    case "301":
                        webDriver.findElement(By.xpath("//a[normalize-space()='301']")).click();
                        if (webDriver.findElement(By.xpath("//p[contains(text(),'This page returned a 301 status code.')]")).isDisplayed()) {
                            System.out.println("This page returned a 301 status code.");
                        }
                        break;            
                    case "404":
                        webDriver.findElement(By.xpath("//a[normalize-space()='404']")).click();
                        if (webDriver.findElement(By.xpath("//p[contains(text(),'This page returned a 404 status code.')]")).isDisplayed()) {
                            System.out.println("This page returned a 404 status code.");
                        }
                        break;            
                    case "500":
                        webDriver.findElement(By.xpath("//a[normalize-space()='500']")).click();
                        if (webDriver.findElement(By.xpath("//p[contains(text(),'This page returned a 500 status code.')]")).isDisplayed()) {
                            System.out.println("This page returned a 500 status code.");
                        }
                        break;            
                    default:
                        System.out.println("No such test.");
                        break;
                }
            }   
        } catch (StaleElementReferenceException e) {
            List<WebElement> listOfHrefLinkElements = webDriver.findElements(By.xpath("//ul//a[@href]"));
        }        
    }

}
