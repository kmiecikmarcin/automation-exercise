package com.automationexercise.framework.browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetup {

    public WebDriver chromeSetup() {

        WebDriver driverChrome = new ChromeDriver();

        driverChrome.manage().window().maximize();
        driverChrome.navigate().to("https://www.automationexercise.com/");

        return driverChrome;
    }
}
