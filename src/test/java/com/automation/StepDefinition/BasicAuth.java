package com.automation.StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class BasicAuth {
    WebDriver webDriver = null;
    public String url, completeUrl;
    String password = "admin";
    String username = "admin";
    // Alert alert;
    
    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @When("user clicks on basic auth")
    public void user_clicks_on_basic_auth() {
        url = "@"+ "the-internet.kineticskunk.co.za/basic_auth";
    }
    
    @And("user enters the password and username")
    public void user_enters_the_password_and_username() {
        completeUrl = "https://" + username + ":" + password + url;
        System.out.println("completeUrl: " + completeUrl);
    }
    
    @Then("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        webDriver.get(completeUrl);
    }
    
    @And("login status")
    public void login_status() {
        String title = webDriver.getTitle();
        System.out.println("The page title is "+title);
        String text = webDriver.findElement(By.tagName("p")).getText();
        System.out.println("The test present in page is ==> "+text);
        // if(webDriver.findElement(By.xpath("//h3[normalize-space()='Basic Auth']")).isDisplayed()) {
        //     System.out.println("Successfully logged in");
        // } else {
        //     System.out.println("Incorrect login credentials"); //Not authorized
        // }
    }
}