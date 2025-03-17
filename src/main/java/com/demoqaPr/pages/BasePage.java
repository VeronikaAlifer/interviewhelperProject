package com.demoqaPr.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public boolean isElementPresent(By by){
        try {
           return driver.findElement(by).isDisplayed();
        }catch (NoSuchElementException | StaleElementReferenceException e){
            return false;
        }
    }

    protected void setText(By by, String value){
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
       element.click();
       element.sendKeys(value);
    }
}
