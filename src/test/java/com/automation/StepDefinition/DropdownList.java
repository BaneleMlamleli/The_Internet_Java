package com.automation.StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class DropdownList {
    WebDriver webDriver = null;
    Actions actions = null;

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
