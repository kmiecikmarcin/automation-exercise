package com.automationexercise.framework.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Category section
    protected WebElement categoryText = driver.findElement(By.xpath("//*[text()='Category']"));
    protected WebElement categoryWomanList = driver.findElement(By.xpath("//*[@id='Women']//parent::*"));
    protected WebElement categoryMenList = driver.findElement(By.xpath("//*[@id='Men']//parent::*"));
    protected WebElement categoryKidsList = driver.findElement(By.xpath("//*[@id='Kids']//parent::*"));

    // Brands section
    protected WebElement brandsText = driver.findElement(By.xpath("//*[text()='Brands']"));

    // Features Items section
    protected WebElement featuresItemsText = driver.findElement(
            By.xpath("//*[text()='Features Items']"));
    protected WebElement recommendedItemsText = driver.findElement(
            By.xpath("//*[text()='recommended items']"));

    public void homePageIsLoaded() {

        waitForElement(categoryText);
        waitForElement(categoryWomanList);
        waitForElement(categoryMenList);
        waitForElement(categoryKidsList);

        waitForElement(brandsText);

        waitForElement(featuresItemsText);
        waitForElement(recommendedItemsText);
    }
}
