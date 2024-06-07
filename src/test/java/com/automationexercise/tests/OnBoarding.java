package com.automationexercise.tests;

import org.junit.jupiter.api.Test;

public class OnBoarding extends BaseTest {

    @Test
    void createNewUser() {
        homePage.signUpAndLoginButton.isDisplayed();
    }
}
