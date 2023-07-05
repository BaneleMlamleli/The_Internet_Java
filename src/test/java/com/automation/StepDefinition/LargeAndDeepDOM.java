package com.automation.StepDefinition;

import org.openqa.selenium.By;
import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class LargeAndDeepDOM  extends BaseClass {
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("user clicks on Large And Deep DOM")
    public void user_clicks_on_large_and_deep_dom() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Large & Deep DOM']")).click();
    }

    @Then("test all rows and column values")
    public void test_all_rows_and_column_values() {
        //Test the deep sibling nesting
        System.out.println("======== SIBLINGS ======");
        for (int row = 1; row <= 50; row++) {
            for (int column = 1; column <= 3; column++) {
                String id = "sibling-" + row + "." + column;
                if (!webDriver.findElement(By.id(id)).isDisplayed()) {
                    System.out.println("TEST FAILED. ID = " + id + ": " + row + "." + column);
                    break;
                }
            }
        }
        System.out.println(". . .\n . . .\n======== SIBLINGS TEST DONE ======");
        
        //Test the table values
        System.out.println("======== TABLE ======");
        for (int row = 1; row <= 50; row++) {
            for (int column = 1; column <= 50; column++) {
                String className = "column-"+column;
                if (!webDriver.findElement(By.className("column-"+column)).isDisplayed()) {
                    System.out.println("TEST FAILED. Class name = " + className);
                    break;
                }
            }
        }
        System.out.println(". . .\n. . .\n======== TABLE TEST DONE ======");
    }
}
