package com.automation.StepDefinition;
import com.automation.core.BaseClass;
import org.openqa.selenium.By;
import io.cucumber.java.en.*;

public class InfiniteScroll  extends BaseClass {
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on Infinite Scroll")
    public void user_clicks_on_infinite_scroll() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Infinite Scroll']")).click();
    }

    @Then("confirm infinite scrolling")
    public void confirm_infinite_scrolling() {
        boolean confirmDisplay = webDriver.findElement(By.xpath("//h3[normalize-space()='Infinite Scroll']")).isDisplayed();
        if (confirmDisplay) {
            System.out.println("Infinite scrolling confirmed. Test passed");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        webDriver.close();
        webDriver.quit();
    }
}
