package com.automationexercise.tests.steps.login;

import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    public WebDriver driver;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;

    public LoginSteps(WebDriver driver, HomePage homePage, CommonElementsPage commonElements) {
        this.driver = driver;
        this.homePage = homePage;
        this.commonElementsPage = commonElements;
    }

    @Step("Logged user sees proper elements on home page")
    public void homePageIsLoaded() {

        // Common elements are loaded for user which logged-in
        commonElementsPage.commonElementsAreLoadedForLoggedInUser();

        // Home page elements are loaded
        homePage.homePageIsLoaded();
    }
}
