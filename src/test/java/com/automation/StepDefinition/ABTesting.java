package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class ABTesting {
    WebDriver webDriver = null;
    // final String BROWSER = "chrome"; //firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
    //     webDriver = new ChromeDriver();
    //     webDriver.manage().window().maximize();
    //     webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
    // }

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

    @And("the driver process is killed")
    public void the_driver_process_is_killed() {
        webDriver.close();
        webDriver.quit();
    }
}
