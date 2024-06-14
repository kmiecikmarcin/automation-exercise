package com.automationexercise.framework.pageObjectModel.SignupAndLoginPages;

import com.automationexercise.framework.helpers.Generators;
import com.automationexercise.framework.helpers.UserData;
import com.automationexercise.framework.pageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupDetailsPage extends BasePage {
    public SignupDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Enter Account Information
    protected WebElement enterAccountInformationText = driver.findElement(
            By.xpath("//*[text()='Enter Account Information']"));
    protected WebElement titleText = driver.findElement(By.xpath("//*[text()='Title']"));
    protected WebElement titleMrCheckbox = driver.findElement(By.xpath("//*[@id='id_gender1']"));
    protected WebElement titleMrsCheckbox = driver.findElement(By.xpath("//*[@id='id_gender2']"));
    protected WebElement nameText = driver.findElement(By.xpath("//*[text()='Name ']"));
    protected WebElement nameInput = driver.findElement(By.xpath("//*[@data-qa='name']"));
    protected WebElement emailText = driver.findElement(By.xpath("//*[text()='Email ']"));
    protected WebElement emailInput = driver.findElement(By.xpath("//*[@data-qa='email']"));
    protected WebElement passwordText = driver.findElement(By.xpath("//*[text()='Password ']"));
    protected WebElement passwordInput = driver.findElement(By.xpath("//*[@data-qa='password']"));
    protected WebElement dateOfBirthText = driver.findElement(By.xpath("//*[text()='Date of Birth']"));
    protected WebElement dayCheckList = driver.findElement(By.xpath("//*[@id='days']"));
    protected WebElement monthCheckList = driver.findElement(By.xpath("//*[@id='months']"));
    protected WebElement yearCheckList = driver.findElement(By.xpath("//*[@id='years']"));
    protected WebElement newsletterCheckBox = driver.findElement(By.xpath("//*[@name='newsletter']"));
    protected WebElement specialOffersCheckBox = driver.findElement(
            By.xpath("//*[@name='optin']"));

    // Address information
    protected WebElement addressInformationText = driver.findElement(
            By.xpath("//*[text()='Address Information']"));
    protected WebElement firstNameText = driver.findElement(
            By.xpath("//*[text()='First name ']"));
    protected WebElement firstNameInput = driver.findElement(
            By.xpath("//*[@id='first_name']"));
    protected WebElement lastNameText = driver.findElement(
            By.xpath("//*[text()='Last name ']"));
    protected WebElement lastNameInput = driver.findElement(
            By.xpath("//*[@id='last_name']"));
    protected WebElement addressText = driver.findElement(
            By.xpath("//*[text()='Address ']"));
    protected WebElement addressInput = driver.findElement(
            By.xpath("//*[@id='address1']"));
    protected WebElement countryText = driver.findElement(
            By.xpath("//*[text()='Country ']"));
    protected WebElement countryCheckBox = driver.findElement(
            By.xpath("//*[text()='United States']//parent::*"));
    protected WebElement stateText = driver.findElement(
            By.xpath("//*[text()='State ']"));
    protected WebElement stateInput = driver.findElement(
            By.xpath("//*[@id='state']"));
    protected WebElement cityText = driver.findElement(
            By.xpath("//*[text()='City ']"));
    protected WebElement cityInput = driver.findElement(
            By.xpath("//*[@id='city']"));
    protected WebElement zipCodeText = driver.findElement(
            By.xpath("//*[text()='Zipcode ']"));
    protected WebElement zipCodeInput = driver.findElement(
            By.xpath("//*[@id='zipcode']"));
    protected WebElement mobileNumberText = driver.findElement(
            By.xpath("//*[text()='Mobile Number ']"));
    protected WebElement mobileNumberInput = driver.findElement(
            By.xpath("//*[@id='mobile_number']"));
    protected WebElement createAccountButton = driver.findElement(
            By.xpath("//*[text()='Create Account']"));

    public void signupDetailsPageIsLoaded() {
        accountInformationElementsAreLoaded();
        addressInformationElementsAreLoaded();
    }
    public void fillAccountInformation() {
        clickOnElement(titleMrCheckbox);

        inputTextToElement(passwordInput, Generators.USER_PASSWORD);

        selectDay();
        selectMonth();
        selectYear();

        clickOnElement(newsletterCheckBox);
        clickOnElement(specialOffersCheckBox);
    }
    public UserData getNameAndEmail() {
        return new UserData(getTextFromValue(nameInput), getTextFromValue(emailInput));
    }
    public void fillAddressInformation() {
        inputTextToElement(firstNameInput, "John");
        inputTextToElement(lastNameInput, "Doe");
        inputTextToElement(addressInput, "Pearl Street");

        selectCountry();

        inputTextToElement(stateInput, "United States");
        inputTextToElement(cityInput, "New York");
        inputTextToElement(zipCodeInput, "10005");
        inputTextToElement(mobileNumberInput, "1660156700");
    }
    public void clickOnCreateAccount() {
        clickOnElement(createAccountButton);
    }
    private void accountInformationElementsAreLoaded() {
        waitForElement(enterAccountInformationText);
        waitForElement(titleText);
        waitForElement(titleMrCheckbox);
        waitForElement(titleMrsCheckbox);
        waitForElement(nameText);
        waitForElement(nameInput);
        waitForElement(emailText);
        waitForElement(emailInput);
        waitForElement(passwordText);
        waitForElement(passwordInput);
        waitForElement(dateOfBirthText);
        waitForElement(dayCheckList);
        waitForElement(monthCheckList);
        waitForElement(yearCheckList);
        waitForElement(newsletterCheckBox);
        waitForElement(specialOffersCheckBox);
    }
    private void addressInformationElementsAreLoaded() {
        waitForElement(addressInformationText);
        waitForElement(firstNameText);
        waitForElement(firstNameInput);
        waitForElement(lastNameText);
        waitForElement(lastNameInput);
        waitForElement(addressText);
        waitForElement(addressInput);
        waitForElement(countryText);
        waitForElement(countryCheckBox);
        waitForElement(stateText);
        waitForElement(stateInput);
        waitForElement(cityText);
        waitForElement(cityInput);
        waitForElement(zipCodeText);
        waitForElement(zipCodeInput);
        waitForElement(mobileNumberText);
        waitForElement(mobileNumberInput);
        waitForElement(createAccountButton);
    }
    private void selectDay() {
        Select select = new Select(dayCheckList);
        select.selectByVisibleText("10");
    }
    private void selectMonth() {
        Select select = new Select(monthCheckList);
        select.selectByVisibleText("March");
    }
    private void selectYear() {
        Select select = new Select(yearCheckList);
        select.selectByVisibleText("1995");
    }
    private void selectCountry() {
        Select select = new Select(countryCheckBox);
        select.selectByVisibleText("United States");
    }
}
