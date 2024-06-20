package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.pageObjectModel.BasePage;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import com.automationexercise.tests.steps.login.LoginSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class Login{

    public String userName;
    public String userEmail;
    public WebDriver driver;
    protected WebDriverSetup webDriverSetup;
    public BasePage basePage;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;
    public Onboarding onboarding;
    public LoginSteps loginSteps;

    public Login() {
        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.chromeSetup();
    }

    @BeforeEach
    void testSetUp() {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        commonElementsPage = new CommonElementsPage(driver);

        onboarding = new Onboarding();

        loginSteps = new LoginSteps(driver, homePage, commonElementsPage);
    }

    @Test
    void deleteUserAccount() {

        // Create na new account
        onboarding.registerUser();

        // Check that user see proper elements after logged-in
        loginSteps.homePageIsLoaded();

        // Delete created account

    }

    @AfterEach
    void testTearDown() {
        driver.quit();
    }
}
