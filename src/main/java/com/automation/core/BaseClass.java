package com.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseClass {
    public static WebDriver webDriver = null;
    
    public static void launchBrowserWithWebsiteHomePage(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "c:\\Users\\ciphe\\Documents\\Programming_local\\webdrivers\\chromedriver.exe");
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "c:\\Users\\ciphe\\Documents\\Programming_local\\webdrivers\\geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                webDriver = new FirefoxDriver(options);
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "c:\\Users\\ciphe\\Documents\\Programming_local\\webdrivers\\msedgedriver.exe");
                webDriver = new EdgeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                break;
            default:
                System.out.println("Selected browser is not available. You can use Chrome, Firefox, or Edge");
                break;
        }
    }
    
    public static void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }
}
