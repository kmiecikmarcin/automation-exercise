package com.automationexercise.framework.browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSetup {

    public WebDriver chromeSetup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-first-run");
        options.addArguments("no-sandbox");
        options.addArguments("--start-maximized");

        WebDriver driverChrome = new ChromeDriver(options);
        driverChrome.navigate().to("https://www.automationexercise.com/");

        return driverChrome;
    }
}
