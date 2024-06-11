package com.automationexercise.tests;

import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.SignupAndLoginPages.SignupAndLoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

class OnBoarding extends BaseTest {

    @Test
    @Step("Register user")
    void createNewUser() {

        // User is on home page and see everything
        homePage.homePageIsLoaded();
        commonElementsPage.commonElementsAreLoaded();

        // Accept consent
        commonElementsPage.acceptGoogleConsent();

        // User clicks on signup button
        commonElementsPage.clickOnSignUpButton();
        
        // Website loads signup and login page
        SignupAndLoginPage signupAndLoginPage = new SignupAndLoginPage(driver);
        signupAndLoginPage.signupAndLoginPageIsLoaded();
        
        // Enter a name and email address
        UserData userData = new UserData(userName, userEmail);
        signupAndLoginPage.enterNameEmailAddressAndClickOnSignup(userData);

        // Fill the details

    }

    @Test
    @Step("Login user with correct email and password")
    void loginUserWithProperData() {

    }
}
