package com.automationexercise.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class OnBoarding extends BaseTest {

    @Test
    @Step("Register a new user")
    void createNewUser() {
        homePage.signUpAndLoginButton.isDisplayed();
    }
}
