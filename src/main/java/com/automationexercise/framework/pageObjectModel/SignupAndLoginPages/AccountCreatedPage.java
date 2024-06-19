package com.automationexercise.framework.pageObjectModel.SignupAndLoginPages;

import com.automationexercise.framework.enums.AccountCreatedMessages;
import com.automationexercise.framework.pageObjectModel.BasePage;
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

    public void accountCreatedPageIsLoaded() {
        waitForElement(accountCreatedText);

        waitForElement(congratulationText);
        waitForElement(descriptionText);

        waitForElement(continueButton);
    }

    public String getAccountCreatedText() {
        waitForElement(accountCreatedText);
        return accountCreatedText.getText();
    }

    public String getCongratulationsText() {
        waitForElement(congratulationText);
        return congratulationText.getText();
    }

    public String getDescriptionText() {
        waitForElement(descriptionText);
        return descriptionText.getText();
    }

    public String clickOnContinueButton() {
        clickOnElement(continueButton);
        return continueButton.getText();
    }
}
