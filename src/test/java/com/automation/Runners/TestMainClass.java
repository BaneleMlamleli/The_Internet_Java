package com.automation.Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\com\\automation\\Features", 
        glue = { "com.automation.StepDefinition" }, 
        monochrome = true, 
        plugin = { "pretty", "html:target/HtmlReports.html", "json:target/JsonReports.json",
                "junit:target/XmlReport.xml" }, 
        tags = "@NotificationMessage"
)
public class TestMainClass {
    
}