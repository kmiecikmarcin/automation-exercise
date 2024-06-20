package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.enums.AccountCreatedMessages;
import com.automationexercise.framework.helpers.Generators;
import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.BasePage;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import com.automationexercise.tests.steps.signup.SignupSteps;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class Onboarding {

    public String userName, userEmail, userPassword;
    public WebDriver driver;
    protected WebDriverSetup webDriverSetup;
    public BasePage basePage;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;
    public SignupSteps signupSteps;

    @BeforeEach
    void testSetUp() {
        userName = Generators.USER_NAME;
        userEmail = Generators.generateEmail();
        userPassword = Generators.USER_PASSWORD;

        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.chromeSetup();

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        commonElementsPage = new CommonElementsPage(driver);

        signupSteps = new SignupSteps(driver, homePage, commonElementsPage, userName, userEmail);
    }

    @AfterEach
    void testTearDown() {
        driver.quit();
    }

    @Test
    @Step("Register user")
    void registerUser() {

        // Home page
        signupSteps.homePageIsLoaded();
        signupSteps.startOnboarding();

        // Signup/Login page
        signupSteps.signupAndLoginPageIsLoaded();
        signupSteps.fillNameAndEmailForSignup();
        signupSteps.clicksOnSignUpButton();

        // Signup details page
        signupSteps.signupDetailsPageIsLoaded();

        UserData userDataOnSignupDetailsPage = signupSteps.getNameAndEmail();

        signupSteps.fillUserDetailsData();
        signupSteps.clickOnCreateAccountButton();

        // Account created page
        signupSteps.accountCreatedPageIsLoaded();
        signupSteps.clickOnContinueButton();

        // Assert
        Assertions.assertEquals(userName, userDataOnSignupDetailsPage.getUserName());
        Assertions.assertEquals(userEmail, userDataOnSignupDetailsPage.getUserEmail());

        Assertions.assertEquals(signupSteps.getAccountCreatedText(),
                AccountCreatedMessages.ACCOUNT_CREATED.getMessage());
        Assertions.assertEquals(signupSteps.getCongratulationsText(),
                AccountCreatedMessages.CONGRATULATIONS.getMessage());
        Assertions.assertEquals(signupSteps.getDescriptionText(),
                AccountCreatedMessages.DESCRIPTION.getMessage());
    }
}
