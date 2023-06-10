package com.automation.Factory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private String browser;
    private WebDriver webDriver;

    public WebDriverFactory(String brwsr, WebDriver driver) {
        this.browser = brwsr;
        this.webDriver = driver;
        openBrowsWebDriver();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String newBrowser) {
        this.browser = newBrowser;
    }
    
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver newWebBrowser) {
        this.webDriver = newWebBrowser;
    }

    public void openBrowsWebDriver() {
        try{
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "c:\\browser_webdrivers\\chromedriver.exe");
                    webDriver = new ChromeDriver();
                    webDriver.manage().window().maximize();
                    webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };break;
                case "firefox":
                    System.setProperty("webdriver.firefox.driver", "c:\\browser_webdrivers\\geckodriver.exe");
                    webDriver = new FirefoxDriver();
                    webDriver.manage().window().maximize();
                    webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", "c:\\browser_webdrivers\\msedgedriver.exe");
                    webDriver = new EdgeDriver();
                    webDriver.manage().window().maximize();
                    webDriver.navigate().to("https://the-internet.kineticskunk.co.za/");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };break;
                default:
                    throw new RuntimeException("Unsupported webdriver: " + webDriver);
            }
        } catch (Exception ex) {
            System.err.println("[Error]: Error when launching driver " + ex.getMessage());
        }
        webDriver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
