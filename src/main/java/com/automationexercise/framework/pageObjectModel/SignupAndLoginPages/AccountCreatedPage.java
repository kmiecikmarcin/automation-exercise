package com.automationexercise.framework.pageObjectModel.SignupAndLoginPages;

import com.automationexercise.framework.pageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage extends BasePage {

    private final String CONGRATULATIONS_TEXT = "Congratulations! Your new account has been successfully created!";
    private final String DESCRIPTION_TEXT = "You can now take advantage of member privileges to " +
            "enhance your online shopping experience with us.";
    public AccountCreatedPage(WebDriver driver) { super(driver); }

    public WebElement accountCreatedText = driver.findElement(By.xpath("//*[text()='Account Created!']"));
    public WebElement congratulationText = driver.findElement(
            By.xpath("//*[text()='"+CONGRATULATIONS_TEXT+"']"));
    public WebElement descriptionText = driver.findElement(
            By.xpath("//*[text()='"+DESCRIPTION_TEXT+"']"));
    private WebElement continueButton = driver.findElement(By.xpath("//*[text()='Continue']"));

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
