package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.helpers.Generators;
import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.BasePage;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import com.automationexercise.framework.pageObjectModel.SignupAndLoginPages.SignupAndLoginPage;
import com.automationexercise.tests.steps.signup.CreateNewUser;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class OnBoarding {

    public String userName;
    public String userEmail;
    public WebDriver driver;
    protected WebDriverSetup webDriverSetup;
    public BasePage basePage;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;
    public CreateNewUser createNewUser;

    public OnBoarding() {
        userName = Generators.userName();
        userEmail = Generators.generateEmail();

        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.chromeSetup();
    }

    @BeforeEach
    void testSetUp() {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        commonElementsPage = new CommonElementsPage(driver);

        createNewUser = new CreateNewUser(driver, homePage, commonElementsPage, userName, userEmail);
    }

    @Test
    @Step("Register user")
    void registerUser() {
        createNewUser.createNewUser();
    }

    @AfterEach
    void testTearDown() {
        driver.quit();
    }
}
