package com.demoqaPr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPracticeFormPage extends BasePage {

    public static final By firstName = By.id("firstName");
    public static final By lastName = By.id("lastName");
    public static final By userEmail = By.id("userEmail");
    public static final By userNumber = By.id("userNumber");


    public AutomationPracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeFormPage fillFirstNameField(String firstNameValue){
        enterTextIntoTextBox(firstName, firstNameValue);
        return new AutomationPracticeFormPage(driver);
    }
}
