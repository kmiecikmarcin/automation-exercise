package com.automationexercise.tests;

import com.automationexercise.framework.browserSetup.WebDriverSetup;
import com.automationexercise.framework.helpers.Generators;
import com.automationexercise.framework.pageObjectModel.BasePage;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class Login {

    public String userName;
    public String userEmail;
    public WebDriver driver;
    protected WebDriverSetup webDriverSetup;

    public Login() {
        userName = Generators.userName();
        userEmail = Generators.generateEmail();

        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.chromeSetup();
    }

    @Test
    @Step("Login user with correct email and password")
    void loginUserWithProperData() {

    }
}
