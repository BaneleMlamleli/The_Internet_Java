package com.automation.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class JQueryUIMenu {
    WebDriver webDriver = null;
    Actions actions = null;
    WebElement firstLevel, secondLevel, thirdLevelPdfDownload, thirdLevelCsvDownload, thirdLevelExcelDownload, secondLevelBackToMenu;
    
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

    @When("user clicks on JQueryUI Menu")
    public void user_clicks_on_JQueryUI_Menu() {
        webDriver.findElement(By.xpath("//a[normalize-space()='JQuery UI Menus']")).click();
    }

    @Then("user download all documents")
    public void user_download_all_documents() {
        actions = new Actions(webDriver);

        firstLevel = webDriver.findElement(By.xpath("//a[@href='#'][normalize-space()='Enabled']"));
        secondLevel = webDriver.findElement(By.xpath("//a[normalize-space()='Downloads']"));
        thirdLevelPdfDownload = webDriver.findElement(By.xpath("//a[@href][normalize-space()='PDF']"));
        thirdLevelCsvDownload = webDriver.findElement(By.xpath("//a[normalize-space()='CSV']"));
        thirdLevelExcelDownload = webDriver.findElement(By.xpath("//a[normalize-space()='Excel']"));
    
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(firstLevel));
        actions.moveToElement(firstLevel).perform();

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(secondLevel));
        actions.moveToElement(secondLevel).perform();
                
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(thirdLevelPdfDownload));
        actions.moveToElement(thirdLevelPdfDownload).click().perform();
    
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(thirdLevelCsvDownload));
        actions.moveToElement(thirdLevelCsvDownload).click().perform();
                
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(thirdLevelExcelDownload));
        actions.moveToElement(thirdLevelExcelDownload).click().perform();
    }
    
    @And("user clicks on back to jquery ui")
    public void user_clicks_on_back_to_jquery_ui() {
        actions = new Actions(webDriver);

        firstLevel = webDriver.findElement(By.xpath("//a[@href='#'][normalize-space()='Enabled']"));
        secondLevel = webDriver.findElement(By.xpath("//a[normalize-space()='Downloads']"));
        secondLevelBackToMenu = webDriver.findElement(By.xpath("//a[normalize-space()='Back to JQuery UI']"));
    
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(firstLevel));
        actions.moveToElement(firstLevel).perform();

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(secondLevelBackToMenu));
        actions.moveToElement(secondLevelBackToMenu).click().perform();

        webDriver.findElement(By.xpath("//a[normalize-space()='Menu']")).click();
    }

}
