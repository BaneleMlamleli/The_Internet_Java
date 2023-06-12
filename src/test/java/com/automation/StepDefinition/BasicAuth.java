package com.automation.StepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class BasicAuth {
    WebDriver webDriver = null;
    public String url;
    Alert alert = null;

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
    }

    @When("login pop-up message box is displayed")
    public void login_pop_up_message_box_is_displayed() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Basic Auth']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^user enters the (.*) and (.*)$")
    public void user_enters_the_password_and_username(String password, String username) {
        alert = webDriver.switchTo().alert();
        alert.sendKeys(password);
        alert.sendKeys(username);
        // url = "https://"+username+":"+password+"@the-internet.kineticskunk.co.za/basic_auth";
    }
    
    @Then("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        alert.accept();
    }
    
    @And("login status")
    public void login_status() {
        System.out.println("The page title is " + webDriver.getTitle());        
        System.out.println("Website text: " + webDriver.findElement(By.tagName("p")).getText());
        // if(webDriver.findElement(By.xpath("//h3[normalize-space()='Basic Auth']")).isDisplayed()) {
        //     System.out.println("Successfully logged in");
        // } else {
        //     System.out.println("Incorrect login credentials"); //Not authorized
        // }
    }
}