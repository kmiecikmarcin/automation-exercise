package com.automationexercise.framework.pageObjectModel.SignupAndLoginPages;

import com.automationexercise.framework.pageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupDetailsPage extends BasePage {
    public SignupDetailsPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement enterAccountInformationText = driver.findElement(By.xpath(""));
}
