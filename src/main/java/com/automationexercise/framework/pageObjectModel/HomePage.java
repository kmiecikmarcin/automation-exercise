package com.automationexercise.framework.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Navigation bar from the top
    public WebElement signUpAndLoginButton = driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
}
