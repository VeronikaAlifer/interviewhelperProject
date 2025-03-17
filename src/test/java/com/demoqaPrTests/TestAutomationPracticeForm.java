package com.demoqaPrTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoqaPr.pages.AutomationPracticeFormPage;
import com.demoqaPrTests.utility.UserGenerator;
import com.interHelpPr.utils.ExtentReportManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;

public class TestAutomationPracticeForm {
    private WebDriver driver;
    private ExtentReports reports;
    private ExtentTest log;
    private AutomationPracticeFormPage formPage;
    private String URL = "https://demoqa.com/automation-practice-form";

    @BeforeClass(alwaysRun = true)
    public void setUpReports() {
        reports = ExtentReportManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        driver = new ChromeDriver();
        formPage = new AutomationPracticeFormPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        log = reports.createTest(method.getName());
    }

    @Test(groups = {"regression"})
    public void verifyPageLoad() {
        log.info("Open the form URL");
        driver.get(URL);

        log.info("Verify that the form is displayed");
        String actualTitle = formPage.getPracticeFormHeader();
        Assert.assertEquals( actualTitle,"Practice Form");

        log.info("Check that the key elements are visible.");
        Assert.assertTrue(formPage.isUserFormIsDisplayed(),
                "The form is not displayed on the page.");
        Assert.assertTrue(formPage.isElementPresent(AutomationPracticeFormPage.firstName),
                "First Name field is not displayed.");
        Assert.assertTrue(formPage.isElementPresent(AutomationPracticeFormPage.lastName),
                "Last Name field is not displayed.");

    }

    @Test(groups = {"smoke"})
    public void fillPracticeForm() throws InterruptedException {

        log.info("Open the practice form page");
        driver.get("https://demoqa.com/automation-practice-form");

        log.info("Fill the practice form fields");
        formPage.setFirstName(UserGenerator.getRandomFirstName())
                .setLastName(UserGenerator.getRandomLastName())
                .setUserEmail(UserGenerator.getRandomEmail())
                .setUserNumber(UserGenerator.getRandomPhone());
    }

    @AfterMethod(alwaysRun = true)
    public void tearsDown(ITestResult testResult) {
        try {
            if (testResult.getStatus() == ITestResult.SUCCESS) {
                log.pass("Test pass successfully");
            } else if (testResult.getStatus() == ITestResult.FAILURE) {
                log.fail(testResult.getThrowable().getMessage());
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearsDownReports() {
        reports.flush();
    }
}
