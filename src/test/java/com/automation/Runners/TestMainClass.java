package com.automation.Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\com\\automation\\Features", 
        glue = { "com.automation.StepDefinition", "com.automation.utility" }, 
        monochrome = true, 
        plugin = { "pretty", "html:target/reports/HtmlReports/HtmlReports.html", "json:target/reports/JsonReports/JsonReports.json", "junit:target/reports/XmlReport.xml" }, 
        tags = "@ABTesting"
)
public class TestMainClass {
    
}