package com.automation.StepDefinition;

import org.openqa.selenium.By;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class DynamicControls extends BaseClass{
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on dynamic controls")
    public void user_clicks_on_dynamic_content() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Dynamic Controls']")).click();
    }

    @Then("user tick the checkbox and clicks on remove button")
    public void user_tick_the_checkbox_and_clicks_on_remove_button() {
        webDriver.findElement(By.xpath("//input[@type='checkbox']")).click();
        webDriver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();
    }

    @And("wait for loading counter")
    public void wait_for_loading_counter() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (webDriver.findElement(By.xpath("//img[@src='/img/ajax-loader.gif']")).isDisplayed()) {
            System.out.println("Loading displayed");
        }
    }

    @And("Add button is displayed with \"It\'s done\" message")
    public void add_button_is_displayed_its_done_message() {
        boolean message = webDriver.findElement(By.xpath("//p[@id='message']")).isDisplayed();
        boolean btnAddIsVisible = webDriver.findElement(By.xpath("//button[normalize-space()='Add']")).isDisplayed();
        if (btnAddIsVisible && message) {
            System.out.println("Message and the 'Add' button are displayed");
        }
    }

    @And("clicks on the Add button")
    public void clicks_on_the_add_button() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    }

    @And("Remove button is displayed with \"It\'s back\" message")
    public void remove_button_is_displayed_with_Its_back_message() {
        if (webDriver.findElement(By.xpath("//button[normalize-space()='Remove']")).isDisplayed()) {
            System.out.println("'Remove' button is displayed again. Test passed!");
        }
    }

    @Then("user clicks on enable button")
    public void user_clicks_on_enable_button() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Enable']")).click();
    }

    @And("message \"It\'s enabled!\" will be displayed")
    public void message_its_enabled_will_be_displayed() {
        boolean message = webDriver.findElement(By.xpath("//p[@id='message']")).getText().contains("It's enabled!");
        System.out.println("Message: " + message);
        boolean btnDisableIsVisible = webDriver.findElement(By.xpath("//button[normalize-space()='Disable']"))
                .isDisplayed();
        if (btnDisableIsVisible && message) {
            System.out.println("Message and the 'Disable' button are displayed");
        }
    }

    @And("enter text in the text box and click on Disable again")
    public void enter_text_in_the_text_box_and_click_on_disable_again() {
        webDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing text field");
    }

    @And("user clicks on Disable button")
    public void user_clicks_on_Disable_button() {
        webDriver.findElement(By.xpath("//button[normalize-space()='Disable']")).click();
    }

    @And("message \"It\'s disabled!\" will be displayed")
    public void message_its_disabled_will_be_displayed() {
        if (webDriver.findElement(By.xpath("//p[@id='message']")).getText().contains("It's disabled!")) {
            System.out.println("'disabled' text message notification displayed");
        }
    }

    @And("check to see text box is editable")
    public void check_to_see_text_box_is_editable() {
        System.out.println("Text field is disabled: "
                + webDriver.findElement(By.xpath("//input[@type='text']")).getAttribute("disabled"));
    }
}
