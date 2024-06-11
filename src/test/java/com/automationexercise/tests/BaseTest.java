package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.helpers.Generators;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import org.junit.jupiter.api.AfterEach;
import com.automationexercise.framework.pageObjectModel.BasePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public String userName;
    public String userEmail;
    public WebDriver driver;
    protected WebDriverSetup webDriverSetup;
    public BasePage basePage;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;

    @BeforeEach
    void testSetUp() {

        userName = Generators.userName();
        userEmail = Generators.generateEmail();

        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.chromeSetup();

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        commonElementsPage = new CommonElementsPage(driver);
    }

    @AfterEach
    void testTearDown() {
        driver.quit();
    }
}
