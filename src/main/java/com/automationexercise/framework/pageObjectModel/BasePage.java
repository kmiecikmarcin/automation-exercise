package com.automationexercise.framework.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public String getTextFromValue(WebElement element) {
        waitForElement(element);
        return element.getAttribute("value");
    }

    public void scrollToElement(WebElement element) {
        int deltaY = element.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }
}
