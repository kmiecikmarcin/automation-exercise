package com.automationexercise.framework.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonElementsPage extends BasePage {
    public CommonElementsPage(WebDriver driver) {
        super(driver);
    }

    // Google
    protected WebElement consentButton = driver.findElement(By.xpath("//*[@class='fc-button-label']"));

    // Logo
    protected WebElement automationExerciseLogo = driver.findElement(
            By.xpath("//*[@class='logo pull-left']"));

    // Navigation bar from the top
    protected WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
    protected WebElement productsButton = driver.findElement(
            By.xpath("//*[text()=' Products']"));
    protected WebElement cartButton = driver.findElement(
            By.xpath("//*[text()=' Cart']"));
    protected WebElement signUpAndLoginButton = driver.findElement(
            By.xpath("//*[text()=' Signup / Login']"));
    protected WebElement testCasesButton = driver.findElement(By.xpath("//*[text()=' Test Cases']"));
    protected WebElement apiTestingButton = driver.findElement(By.xpath("//*[text()=' API Testing']"));
    protected WebElement videoTutorialsButton = driver.findElement(
            By.xpath("//*[text()=' Video Tutorials']"));
    protected WebElement contactUsButton = driver.findElement(By.xpath("//*[text()=' Contact us']"));

    //
    protected WebElement subscriptionText = driver.findElement(By.xpath("//*[text()='Subscription']"));
    protected WebElement yourEmailAddressInput = driver.findElement(By.xpath("//*[@id='subscribe']"));
    protected WebElement subscribeButton = driver.findElement(By.xpath("//*[@id='susbscribe_email']"));

    // Others
    protected WebElement scrollUpButton = driver.findElement(By.xpath("//*[@id='scrollUp']"));

    public void commonElementsAreLoaded() {

        waitForElement(automationExerciseLogo);

        waitForElement(homeButton);
        waitForElement(productsButton);
        waitForElement(cartButton);
        waitForElement(signUpAndLoginButton);
        waitForElement(testCasesButton);
        waitForElement(apiTestingButton);
        waitForElement(videoTutorialsButton);
        waitForElement(contactUsButton);

        waitForElement(subscriptionText);
        waitForElement(yourEmailAddressInput);
        waitForElement(subscribeButton);

        waitForElement(scrollUpButton);
    }

    public void clickOnSignUpButton() {
        clickOnElement(signUpAndLoginButton);
    }

    public void acceptGoogleConsent() {
        clickOnElement(consentButton);
    }
}
