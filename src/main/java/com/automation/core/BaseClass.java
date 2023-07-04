package com.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    public static WebDriver webDriver = null;
    
    public static void launchBrowserWithWebsiteHomePage(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "c:\\browser_webdrivers\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "c:\\browser_webdrivers\\msedgedriver.exe");
                webDriver = new EdgeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                break;
            default:
                System.out.println("Selected browser is not available. You can use Chrome, Firefox, or Edge");
                break;
        }
    }
    
    public static void close_browser() {
        webDriver.close();
        webDriver.quit();
    }
}
