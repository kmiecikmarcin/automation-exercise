package com.automationexercise.framework.pageObjectModel.SignupAndLoginPages;

import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupAndLoginPage extends BasePage {
    public SignupAndLoginPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement loginToYourAccountText = driver.findElement(
            By.xpath("//*[text()='Login to your account']"));
    protected WebElement loginEmailAddressInput = driver.findElement(
            By.xpath("//*[@action='/login']//*[@type='email']"));
    protected WebElement passwordInput = driver.findElement(By.xpath("//*[@name='password']"));
    protected WebElement loginButton = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
    protected WebElement orButton = driver.findElement(By.xpath("//*[text()='OR']"));
    protected WebElement newUserSignupText = driver.findElement(
            By.xpath("//*[text()='New User Signup!']"));
    protected WebElement nameInput = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
    protected WebElement signupEmailAddressInput = driver.findElement(
            By.xpath("//*[@action='/signup']//*[@type='email']"));
    protected WebElement signupButton = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));

    @Step("Check that elements on signup/login page are loaded")
    public void signupAndLoginPageIsLoaded() {

        waitForElement(loginToYourAccountText);
        waitForElement(loginEmailAddressInput);
        waitForElement(passwordInput);
        waitForElement(loginButton);

        waitForElement(orButton);

        waitForElement(newUserSignupText);
        waitForElement(nameInput);
        waitForElement(signupEmailAddressInput);
    }

    @Step("Fill a name and address email")
    public void enterNameEmailAddress(UserData userData) {

        String name = userData.getUserName();
        String emailAddress = userData.getUserEmail();

        inputTextToElement(nameInput, name);
        inputTextToElement(signupEmailAddressInput, emailAddress);
    }

    @Step("Click on signup button")
    public void clicksOnSignupButton() {
        clickOnElement(signupButton);
    }
}
