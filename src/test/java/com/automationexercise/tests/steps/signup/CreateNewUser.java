package com.automationexercise.tests.steps.signup;

import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import com.automationexercise.framework.pageObjectModel.SignupAndLoginPages.SignupAndLoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateNewUser {

    public WebDriver driver;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;
    public String userName;
    public String userEmail;

    public CreateNewUser(WebDriver driver, HomePage homePage, CommonElementsPage commonElements, String userName,
                         String userEmail) {
        this.driver = driver;
        this.homePage = homePage;
        this.commonElementsPage = commonElements;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    @Step("Register user")
    public void createNewUser() {

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
}
