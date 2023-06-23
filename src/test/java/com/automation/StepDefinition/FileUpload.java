package com.automation.StepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileUpload {
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

    @When("user clicks on File Upload")
    public void user_clicks_on_file_upload() {
        webDriver.findElement(By.xpath("//a[normalize-space()='File Upload']")).click();
    }

    @Then("user clicks on choose file")
    public void user_clicks_on_choose_file() {
        // webDriver.findElement(By.xpath("//input[@id='file-upload']")).click();
        webDriver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\BaneleMlamleli\\Downloads\\logo.png");
    }
    
    @And("user clicks on upload button once file has been chosen")
    public void user_clicks_on_upload_button_once_file_has_been_chosen() {
        webDriver.findElement(By.xpath("//input[@id='file-submit']")).click();
    }
    
    @And("confirmation is displayed")
    public void confirmation_is_displayed() {
        if (webDriver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']")).isDisplayed()) {
            System.out.println("File uploaded successfully!");
        }
    }
    
    @Then("user drags a file from system into the website upload box")
    public void user_drags_a_file_from_system_into_the_website_upload_box() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.id("drag-drop-upload"))
                .sendKeys("C:\\Users\\BaneleMlamleli\\Downloads\\logo.png");
        webDriver.findElement(By.id("drag-drop-upload")).click();
    }

}
