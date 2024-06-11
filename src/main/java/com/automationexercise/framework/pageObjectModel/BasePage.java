package com.automationexercise.framework.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element) {
        element.isDisplayed();
    }

    public void clickOnElement(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void inputTextToElement(WebElement element, String text) {
        waitForElement(element);
        element.sendKeys(text);
    }
}
