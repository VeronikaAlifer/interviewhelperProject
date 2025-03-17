package com.interHelperPrTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.interHelpPr.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.interHelpPr.pages.HomePage;


import java.lang.reflect.Method;
import java.time.Duration;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;
    private ExtentReports extentReports;
    private ExtentTest report;
    private String URL = "https://interviewhelper.web.app/";
    private static final String LIGHT_THEME = "light";
    private static final String DARK_THEME = "dark";


    @BeforeClass(alwaysRun = true)
    public void setUpReports() {
        extentReports = ExtentReportManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(driver);
        report = extentReports.createTest(method.getName());

        if (report == null) {
            System.out.println("Report is null in setUp method.");
        }
    }

    @Test(groups = "smoke")
    public void testPageTitleIsCorrect() {
        report.info("Open the home page");
        driver.get(URL);

        report.info("Verify the page title");
        String expectedTitle = "Interview Helper - prepare to technical interview";
        String actualTitle = homePage.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle,
                "The page title is incorrect. Expected: " + expectedTitle + " but found: " + actualTitle);
    }

    @Test(groups = {"regression"})
    public void testThemeButton() {
        report.info("Open the home page");
        driver.get(URL);

        report.info("Verify default theme");
        String actualValue = homePage.getThemeValue();
        Assert.assertEquals(actualValue, LIGHT_THEME,
                "The expected theme is incorrect.");

        report.info("Click the theme button");
        homePage.clickThemeButton();

        report.info("Verify theme");
        actualValue = homePage.getThemeValue();
        Assert.assertEquals(actualValue, DARK_THEME,
                "The expected theme is incorrect. ");

    }

    @Test(groups = {"regression"})
    public void  testOfSideNavButtonPresenceAndFunctionality(){
        report.info("Open the home page");
        driver.get(URL);

        report.info("Verify that the SideNav button is displayed");
        boolean isDisplayed = homePage.isSideNavButtonDisplayed();
        Assert.assertTrue(isDisplayed, "The sidenav button should be displayed.");

        report.info("Click the SideNav button.");
        homePage.clickSideNavButton();

        report.info("Verify that the topic panel opens as expected.");
        boolean isTopicPanelDisplayed = homePage.isTopicPanelDisplayed();
        Assert.assertTrue(isTopicPanelDisplayed, "The topic panel is not displayed");
    }


    @AfterMethod(alwaysRun = true)
    public void tearsDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                report.pass("Test passed successfully.");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                report.fail(result.getThrowable().getMessage());
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearsDownReporter() {
        extentReports.flush();
    }
}
