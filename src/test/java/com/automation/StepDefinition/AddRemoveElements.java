package com.automation.StepDefinition;

import org.openqa.selenium.By;
import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class AddRemoveElements extends BaseClass{
    int amountOfDeleteButtons = 0;

    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("the user clicks on the AddRemoveElements on the website")
    public void the_user_clicks_on_the_AddRemoveElements_on_the_website() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Add/Remove Elements']")).click();
    }

    @And("the user clicks on the button AddElement")
    public void the_user_clicks_on_the_button_AddElement() {
        for (int i = 0; i <= 2; i++) {
            webDriver.findElement(By.xpath("//button[@onclick='addElement()']")).click(); // you can also user: a[href='/add_remove_elements/']
            amountOfDeleteButtons++;
        }
    }

    @Then("the button Delete is displayed")
    public void the_button_Delete_is_displayed() {
        boolean btnIsDisplayed = webDriver.findElement(By.xpath("//div[@id='elements']//button[1]")).isDisplayed();
        System.out.println((btnIsDisplayed) ? "button test display is successful" : "button test display has failed");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @And("the user clicks on the button Delete")
    public void the_user_clicks_on_the_button_Delete() {
        while (amountOfDeleteButtons != 0) {
            webDriver.findElement(By.xpath("//div[@id='elements']//button[1]")).click();
            amountOfDeleteButtons--;
        }
        // =============================
        // boolean btnDeleteIsDisplayed = webDriver.findElement(By.xpath("//div[@id='elements']//button[1]")).isDisplayed();
        // while (btnDeleteIsDisplayed) {
        //     webDriver.findElement(By.xpath("//div[@id='elements']//button[1]")).click();
        // }
        // =============================
        // System.out.println("isDisplayed: " + btnDeleteIsDisplayed);
        // int amountOfDeleteButtons = 0;
        // while (btnDeleteIsDisplayed) {
        //     System.out.println("isDisplayed INSIDE LOOP = " + btnDeleteIsDisplayed + " : amountOfDeleteButtons = " + amountOfDeleteButtons);
        //     amountOfDeleteButtons++;
        // }

        // System.out.println("amountOfDeleteButtons: " + amountOfDeleteButtons);

        // for (int i = 0; i < amountOfDeleteButtons; i++) {
        //     webDriver.findElement(By.xpath("//div[@id='elements']//button[1]")).click();
        // }
        // =============================
        // System.out.println("btnDeleteIsDisplayed: " + btnDeleteIsDisplayed);
        // int i = 0;
        // do {
        //     if (btnDeleteIsDisplayed) {
        //         webDriver.findElement(By.xpath("//div[@id='elements']//button[1]")).click();
        //         System.out.println("Inside the loop: " + i + " : " + btnDeleteIsDisplayed);
        //     } else {
        //         System.out.println("Inside the loop (FALSE): " + i + " : " + btnDeleteIsDisplayed);
        //         System.err.println("Element either does not exist or the locator is incorrect");
        //         break;
        //     }
        //     i++;
        // } while (btnDeleteIsDisplayed);
        // ===============================
        // List<WebElement> listOElements = webDriver.findElements(By.xpath("//div[@id='elements']//button[1]"));
        // System.out.println("Amount of Delete buttons: " + listOElements.size());
        // if (listOElements.size() > 0) {
        //     for (WebElement webElement : listOElements) {
        //         webElement.click();
        //     }
        // } else {
        //     System.err.println("Element either does not exist or the locator is incorrect");
        // }
    }
    
    // @And("close browser")
    // public void close_browser() {
    //     BaseClass.closeBrowser();
    // }
}
