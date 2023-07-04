package com.automation.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class SortableDataTables {
    WebDriver webDriver = null;
    
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
