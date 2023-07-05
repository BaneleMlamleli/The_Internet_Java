package com.automation.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class SortableDataTables  extends BaseClass{
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on Sortable Data Tables")
    public void user_clicks_on_sortable_data_tables() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Sortable Data Tables']")).click();
    }

    @Then("sort each table")
    public void sort_each_table() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3));

        //Example 1
        webDriver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]")).click();
        
        //Example 2
        webDriver.findElement(By.xpath("//span[@class='first-name']")).click();

    }
}
