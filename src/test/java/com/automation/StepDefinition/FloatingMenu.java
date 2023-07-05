package com.automation.StepDefinition;

import java.util.List;
import com.automation.core.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;

public class FloatingMenu extends BaseClass{
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
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
