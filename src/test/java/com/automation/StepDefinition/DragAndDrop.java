package com.automation.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class DragAndDrop extends BaseClass {
    Actions actions = null;
    final String BROWSER = "chrome"; //chrome, firefox, edge

    @Given("a user is on the website home page")
    public void a_user_is_on_the_website_home_page() {
        BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    }

    @When("user clicks on drag and drop element")
    public void user_clicks_on_drag_and_drop_element() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Drag and Drop']")).click();
    }

    @Then("drag and drop box A to box B")
    public void drag_and_drop_box_a_to_box_b() {
        WebElement draggable = webDriver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement droppable = webDriver.findElement(By.xpath("//div[@id='column-b']"));
        actions = new Actions(webDriver);
        actions.dragAndDrop(draggable, droppable).perform();
    }
}
