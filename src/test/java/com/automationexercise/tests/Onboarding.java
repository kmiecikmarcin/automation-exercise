package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.enums.AccountCreatedMessages;
import com.automationexercise.framework.helpers.Generators;
import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.BasePage;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import com.automationexercise.tests.steps.signup.SignupNewUser;
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
    public SignupNewUser signupNewUser;

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

        signupNewUser = new SignupNewUser(driver, homePage, commonElementsPage, userName, userEmail);
    }

    @AfterEach
    void testTearDown() {
        driver.quit();
    }

    @Test
    @Step("Register user")
    void registerUser() {

        // Home page
        signupNewUser.homePageIsLoaded();
        signupNewUser.startOnboarding();

        // Signup/Login page
        signupNewUser.signupAndLoginPageIsLoaded();
        signupNewUser.fillNameAndEmailForSignup();
        signupNewUser.clicksOnSignUpButton();

        // Signup details page
        signupNewUser.signupDetailsPageIsLoaded();

        UserData userDataOnSignupDetailsPage = signupNewUser.getNameAndEmail();

        signupNewUser.fillUserDetailsData();
        signupNewUser.clickOnCreateAccountButton();

        // Account created page
        signupNewUser.accountCreatedPageIsLoaded();

        // Assert
        Assertions.assertEquals(userName, userDataOnSignupDetailsPage.getUserName());
        Assertions.assertEquals(userEmail, userDataOnSignupDetailsPage.getUserEmail());

        Assertions.assertEquals(signupNewUser.getAccountCreatedText(),
                AccountCreatedMessages.ACCOUNT_CREATED.getMessage());
        Assertions.assertEquals(signupNewUser.getCongratulationsText(),
                AccountCreatedMessages.CONGRATULATIONS.getMessage());
        Assertions.assertEquals(signupNewUser.getDescriptionText(),
                AccountCreatedMessages.DESCRIPTION.getMessage());
    }
}
