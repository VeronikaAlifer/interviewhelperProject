package com.demoqaPr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AutomationPracticeFormPage extends BasePage {

    public static final By firstName = By.id("firstName");
    public static final By lastName = By.id("lastName");
    public static final By userEmail = By.id("userEmail");
    public static final By userNumber = By.id("userNumber");
    public static final By practiceFormHeader = By.tagName("h1");
    public static final By userForm = By.id("userForm");


    public AutomationPracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeFormPage setFirstName(String firstNameValue) {
        setText(firstName, firstNameValue);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value) {
        setText(lastName, value);
        return this;
    }

    public AutomationPracticeFormPage setUserEmail(String email) {
        setText(userEmail, email);
        return this;
    }

    public AutomationPracticeFormPage setUserNumber(String phoneNumber) {
        setText(userNumber, phoneNumber);
        return this;
    }

    public String getPracticeFormHeader(){
        return driver.findElement(practiceFormHeader).getText();
    }

    public boolean isUserFormIsDisplayed(){
        return isElementPresent(userForm);
    }
}
