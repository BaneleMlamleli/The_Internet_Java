package com.automation.StepDefinition;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.automation.core.BaseClass;
import io.cucumber.java.en.*;

public class Geolocation  extends BaseClass {
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("user clicks on Geolocation")
    public void user_clicks_on_geolocation() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Geolocation']")).click();
    }

    @Then("click on where am I button and accept alert")
    public void click_on_where_am_I_button_and_accept_alert() {
        if (webDriver.findElement(By.xpath("//p[@id='demo']")).isDisplayed()) {
            DesiredCapabilities caps = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
        
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("profile.default_content_setting_values.notifications", 1);
        
            options.setExperimentalOption("prefs", prefs);
            caps.setCapability(ChromeOptions.CAPABILITY, options);

            webDriver.findElement(By.xpath("//button[@onclick='getLocation()']")).click();
        }
    }
    
    @And("click on See it on Google")
    public void click_on_See_it_on_Google() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//div[@id='map-link']/a")).click();
    }
}
