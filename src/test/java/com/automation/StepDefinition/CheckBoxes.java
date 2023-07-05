package com.automation.StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class CheckBoxes extends BaseClass{

    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on Checkboxes")
    public void user_clicks_checkboxes() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Checkboxes']")).click();
    }

    @Then("user tick checkbox 1 and untick checkbox 2")
    public void user_tick_checkbox_1_and_untick_checkbox_2() {
        List<WebElement> listOfCheckboxes = webDriver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        System.out.println("Size: " + listOfCheckboxes.size() + "\nCheckbox 1: " + listOfCheckboxes.get(0).isSelected()
                + "\nCheckbox 2: " + listOfCheckboxes.get(1).isSelected() + "\n==================");
        int incr = 1;
        for (WebElement webElement : listOfCheckboxes) {
            if (webElement.isSelected()) {
                webElement.click();
            } else {
                webElement.click();
            }
            System.out.println("Checkbox "+ (incr++) +": " + webElement.isSelected());
            //input[1]
            //form[@id='checkboxes']
        }
    }
}