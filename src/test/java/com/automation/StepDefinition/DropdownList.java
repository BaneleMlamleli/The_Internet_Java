package com.automation.StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class DropdownList extends BaseClass {
    Actions actions = null;
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("user clicks on dropdown link")
    public void user_clicks_on_dropdown() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Dropdown']")).click();
    }

    @Then("user clicks on the dropdown element and select first option")
    public void user_clicks_on_the_dropdown_element_and_select_first_option() {
        Select dropdownList = new Select(webDriver.findElement(By.xpath("//select[@id='dropdown']")));
        List <WebElement> dropdownListCount = dropdownList.getOptions();
        System.out.println("Array size: " + dropdownListCount.size());
        dropdownList.selectByIndex(1);
        for (WebElement webElementDropdownList : dropdownListCount) {
            System.out.println(webElementDropdownList.getText());
        }
    }
}
