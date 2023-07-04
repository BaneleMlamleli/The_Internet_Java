package com.automation.StepDefinition;

import org.openqa.selenium.By;
import com.automation.core.BaseClass;
import io.cucumber.java.en.*;

public class ABTesting extends BaseClass{
    // WebDriver webDriver = null;
    final String BROWSER = "chrome"; //firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("the user click on the A\\/B Testing element")
    public void the_user_click_on_the_a_b_testing_element() {
        webDriver.findElement(By.xpath("//a[normalize-space()='A/B Testing']")).click();
    }

    @Then("the user is redirected to the A\\/B Testing variation page")
    public void the_user_is_redirected_to_the_a_b_testing_variation_page() {
        String pageSource = webDriver.getPageSource();
        boolean val = pageSource.contains("A/B Test Variation 1");
        System.out.println((val) ? "page test successful" : "page test failed");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
