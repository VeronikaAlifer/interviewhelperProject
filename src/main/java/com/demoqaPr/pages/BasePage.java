package com.demoqaPr.pages;

import org.openqa.selenium.*;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;

    }

    public boolean isElementPresent(By by){
        try {
           return driver.findElement(by).isDisplayed();
        }catch (NoSuchElementException | StaleElementReferenceException e){
            return false;
        }
    }

    protected BasePage enterTextIntoTextBox(By by, String value){
       WebElement element = driver.findElement(by);
       element.click();
       element.sendKeys(value);
       return new BasePage(driver);
    }
}
