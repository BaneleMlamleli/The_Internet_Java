package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileDownload {
    WebDriver webDriver = null;
    Actions actions = null;

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
    //     webDriver = new ChromeDriver();
    //     webDriver.manage().window().maximize();
    //     webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
    //     try {
    //         Thread.sleep(2000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
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
