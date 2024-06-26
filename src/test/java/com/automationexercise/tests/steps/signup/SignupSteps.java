package com.automationexercise.tests.steps.signup;

import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.CommonElementsPage;
import com.automationexercise.framework.pageObjectModel.HomePage;
import com.automationexercise.framework.pageObjectModel.SignupAndLoginPages.AccountCreatedPage;
import com.automationexercise.framework.pageObjectModel.SignupAndLoginPages.SignupAndLoginPage;
import com.automationexercise.framework.pageObjectModel.SignupAndLoginPages.SignupDetailsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SignupSteps {

    public WebDriver driver;
    public HomePage homePage;
    public CommonElementsPage commonElementsPage;
    public String userName;
    public String userEmail;

    public SignupSteps(WebDriver driver, HomePage homePage, CommonElementsPage commonElements, String userName,
                       String userEmail) {
        this.driver = driver;
        this.homePage = homePage;
        this.commonElementsPage = commonElements;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    @Step("User sees elements on home page")
    public void homePageIsLoaded() {
        // Accept consent
        commonElementsPage.acceptGoogleConsent();

        // User is on home page and see everything
        homePage.homePageIsLoaded();
        commonElementsPage.commonElementsAreLoaded();
    }

    @Step("User starts onboarding journey")
    public void startOnboarding() {
        // User clicks on signup button
        commonElementsPage.clickOnSignUpButton();
    }

    @Step("Website loads signup and login page")
    public void signupAndLoginPageIsLoaded() {
        // Website loads signup and login page
        SignupAndLoginPage signupAndLoginPage = new SignupAndLoginPage(driver);
        signupAndLoginPage.signupAndLoginPageIsLoaded();
    }

    @Step("User fills name and email")
    public void fillNameAndEmailForSignup() {
        // Enter a name and email address
        SignupAndLoginPage signupAndLoginPage = new SignupAndLoginPage(driver);
        UserData userData = new UserData(userName, userEmail);
        signupAndLoginPage.enterNameEmailAddress(userData);
    }

    @Step("User clicks on signup button")
    public void clicksOnSignUpButton() {
        SignupAndLoginPage signupAndLoginPage = new SignupAndLoginPage(driver);
        signupAndLoginPage.clicksOnSignupButton();
    }

    @Step("User sees elements on signup details page")
    public void signupDetailsPageIsLoaded() {
        // Check that signup details page is loaded
        SignupDetailsPage signupDetailsPage = new SignupDetailsPage(driver);
        signupDetailsPage.signupDetailsPageIsLoaded();
    }

    @Step("Website returns a name and email from signup details page")
    public UserData getNameAndEmail() {
        // Returns username and email
        SignupDetailsPage signupDetailsPage = new SignupDetailsPage(driver);
        return signupDetailsPage.getNameAndEmail();
    }

    @Step("User fills a details")
    public void fillUserDetailsData() {
        SignupDetailsPage signupDetailsPage = new SignupDetailsPage(driver);

        // Fill the details
        signupDetailsPage.fillAccountInformation();
        signupDetailsPage.fillAddressInformation();
    }

    @Step("User clicks on create account button")
    public void clickOnCreateAccountButton() {
        SignupDetailsPage signupDetailsPage = new SignupDetailsPage(driver);

        // Click on create account
        signupDetailsPage.clickOnCreateAccount();
    }

    @Step("User sees elements on account created page")
    public void accountCreatedPageIsLoaded() {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        // Check that elements are visible
        accountCreatedPage.accountCreatedPageIsLoaded();
    }

    @Step("User sees proper that account is created")
    public String getAccountCreatedText() {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        // Check that elements are visible
        return accountCreatedPage.getAccountCreatedText();
    }

    @Step("User sees proper congratulations message")
    public String getCongratulationsText() {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        // Check that elements are visible
        return accountCreatedPage.getCongratulationsText();
    }

    @Step("User sees proper description")
    public String getDescriptionText() {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        // Check that elements are visible
        return accountCreatedPage.getDescriptionText();
    }

    @Step("User clicks on continue button")
    public void clickOnContinueButton() {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        // User clicks on continue button
        accountCreatedPage.clickOnContinueButton();
    }
}
