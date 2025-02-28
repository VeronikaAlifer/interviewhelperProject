import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utility.ExtentReportManager;

import java.lang.reflect.Method;
import java.time.Duration;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;
    private ExtentReports extentReports;
    private ExtentTest report;
    private String URL = "https://interviewhelper.web.app/";

    @BeforeClass
    public void setUpReports() {
        extentReports = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(driver);
        report = extentReports.createTest(method.getName());
    }

    @Test
    public void testPageTitleIsCorrect() {
        report.info("Open the home page");
        driver.get(URL);

        report.info("Verify the page title");
        String expectedTitle = "Interview Helper - prepare to technical interview";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle,
                "The page title is incorrect. Expected: " + expectedTitle + " but found: " + actualTitle);
    }

    @AfterMethod
    public void tearsDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                report.pass("Test passed successfully.");
            }
            else if (result.getStatus() == ITestResult.FAILURE) {
                report.fail(result.getThrowable().getMessage());
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterClass
    public void tearsDownReporter() {
        extentReports.flush();
    }
}
