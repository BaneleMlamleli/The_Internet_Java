package com.automation.StepDefinition;

import org.openqa.selenium.By;
import com.automation.core.BaseClass;
import io.cucumber.java.en.*;

public class ChallengingDom extends BaseClass {
    
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on Challenging Dom")
    public void user_clicks_on_Challenging_Dom() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Challenging DOM']")).click();
    }

    @And("user clicks on the blue, red, green button")
    public void user_clicks_on_the_blue_red_green_button() {
        webDriver.findElement(By.xpath("//a[@class=\"button\"]")).click();
        webDriver.findElement(By.xpath("//a[@class=\"button alert\"]")).click();
        webDriver.findElement(By.xpath("//a[@class=\"button success\"]")).click();
    }

    @And("user clicks on edit in the table")
    public void user_clicks_on_edit_in_the_table() {
        for (int i = 1; i <= 10; i++) {
            webDriver.findElement(
                    By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[" + i
                            + "]/td[7]/a[1]"))
                    .click();
        }
    }

    @Then("url is appended with the word edit")
    public void url_is_appended_with_the_word_edit() {
        if (webDriver.getCurrentUrl().endsWith("edit")) {
            System.out.println("'edit' has been clicked/tested successfully");
        }

    }
    
    @And("user clicks on delete in the table")
    public void user_clicks_on_delete_in_the_table() {
        for (int i = 1; i <= 10; i++) {
            webDriver.findElement(
                    By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[" + i
                            + "]/td[7]/a[2]"))
                    .click();
        }
    }

    @Then("url is appended with the word delete")
    public void url_is_appended_with_the_word_delete() {
        if (webDriver.getCurrentUrl().endsWith("edit")) {
            System.out.println("'delete' has been clicked/tested successfully");
        }
    }

    @And("the answer box changes the number at page load time")
    public void the_answer_box_changes_the_number_at_page_load_time() {
        if (webDriver.findElement(By.xpath("//canvas[@id='canvas']")).isDisplayed()) {
            System.out.println("Answer section is tested/displayed successfully");
        }
    }
}