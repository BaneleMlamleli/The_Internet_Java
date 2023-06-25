package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class FormAuthentication {
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

    @When("user clicks on Form Authentication")
    public void user_clicks_on_form_authentication() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Form Authentication']")).click();
    }

    @Then("^user enter (.*) and (.*) for authentication$")
    public void user_enter_password_and_username_for_authentication(String username, String password) {
        webDriver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("login status is confirmed")
    public void login_status_is_confirmed() {
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        if (webDriver.findElement(By.xpath("//div[@id='flash']")).getText().contains("Your username is invalid")) {
            System.out.println("Incorrect username");
        }
        
        if (webDriver.findElement(By.xpath("//div[@id='flash']")).getText().contains("Your password is invalid")) {
            System.out.println("Incorrect password");
        }

        if (webDriver.findElement(By.xpath("//div[@id='flash']")).getText().contains("You logged into a secure area!")) {
            System.out.println("Correct login credentials");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            webDriver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
            if (webDriver.findElement(By.xpath("//div[@id='flash']")).getText().contains(" You logged out of the secure area!")) {
                System.out.println("Logged out successfully");
            }
        }
    }
}