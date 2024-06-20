package com.automationexercise.framework.pageObjectModel.SignupAndLoginPages;

import com.automationexercise.framework.enums.AccountCreatedMessages;
import com.automationexercise.framework.pageObjectModel.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage extends BasePage {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement accountCreatedText = driver.findElement(
            By.xpath("//*[text()='Account Created!']"));
    protected WebElement congratulationText = driver.findElement(
            By.xpath("//*[text()='" + AccountCreatedMessages.CONGRATULATIONS.getMessage() + "']"));
    protected WebElement descriptionText = driver.findElement(
            By.xpath("//*[text()='" + AccountCreatedMessages.DESCRIPTION.getMessage() + "']"));
    protected WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue']"));

    @Step("Check that elements on account created page are loaded")
    public void accountCreatedPageIsLoaded() {
        waitForElement(accountCreatedText);

        waitForElement(congratulationText);
        waitForElement(descriptionText);

        waitForElement(continueButton);
    }

    @Step("Take a account created text")
    public String getAccountCreatedText() {
        waitForElement(accountCreatedText);
        return accountCreatedText.getText();
    }

    @Step("Take a congratulations text after account creation")
    public String getCongratulationsText() {
        waitForElement(congratulationText);
        return congratulationText.getText();
    }

    @Step("Take a description text after account creation")
    public String getDescriptionText() {
        waitForElement(descriptionText);
        return descriptionText.getText();
    }

    @Step("Click on continue button")
    public String clickOnContinueButton() {
        clickOnElement(continueButton);
        return continueButton.getText();
    }
}
