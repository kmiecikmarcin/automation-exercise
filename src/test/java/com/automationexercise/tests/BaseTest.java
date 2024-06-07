package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.pageObjectModel.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.automationexercise.framework.pageObjectModel.BasePage;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverSetup webDriverSetup;
    public BasePage basePage;
    public HomePage homePage;

    @BeforeEach
    void testSetUp() {

        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.chromeSetup();

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
    }

    @AfterEach
    void testTearDown() {
        driver.quit();
    }
}
