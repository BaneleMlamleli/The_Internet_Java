package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.automation.core.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileDownload  extends BaseClass {Actions actions = null;

    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on File Download")
    public void user_clicks_on_file_download() {
        webDriver.findElement(By.xpath("//a[normalize-space()='File Download']")).click();
    }

    @Then("user downloads all files")
    public void user_downloads_all_files() {
        webDriver.findElement(By.xpath("//a[normalize-space()='some-file.txt']")).click();
        webDriver.findElement(By.xpath("//a[normalize-space()='logo.png']")).click();
        webDriver.findElement(By.xpath("//a[normalize-space()='TestDoc1.docx']")).click();
    }
}
