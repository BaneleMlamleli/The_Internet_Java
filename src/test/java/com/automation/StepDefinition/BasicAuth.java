package com.automation.StepDefinition;
import org.openqa.selenium.By;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class BasicAuth extends BaseClass{
    public String url, completeUrl;
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("user clicks on basic auth")
    public void user_clicks_on_basic_auth() {
        url = "@"+ "the-internet.kineticskunk.co.za/basic_auth";
    }
    
    @And("user enters the {word} and {word}")
    public void user_enters_the_password_and_username(String username, String password) {
        completeUrl = "https://" + username + ":" + password + url;
        System.out.println("completeUrl: " + completeUrl);
    }
    
    @Then("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        webDriver.get(completeUrl);
    }
    
    @And("login status")
    public void login_status() {
        if (webDriver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).isDisplayed()) {
            System.out.println("Successfully logged in");
        }
        
        if(webDriver.findElement(By.xpath("//body[contains(text(),'Not authorized')]")).isDisplayed()){
            System.out.println("Incorrect login credentials"); //Not authorized
        }
    }
}