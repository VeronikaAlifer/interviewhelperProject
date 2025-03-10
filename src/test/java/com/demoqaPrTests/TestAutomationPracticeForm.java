package com.demoqaPrTests;

import com.demoqaPr.pages.AutomationPracticeFormPage;
import com.demoqaPrTests.utility.UserGenerator;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAutomationPracticeForm {

    @Test
    public void fillPracticeForm() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");

        formPage.fillFirstNameField(UserGenerator.getRandomFirstName());
    }
}
