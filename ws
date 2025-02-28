[1mdiff --git a/src/main/java/pages/HomePage.java b/src/main/java/pages/HomePage.java[m
[1mindex b98c06c..34ffa05 100644[m
[1m--- a/src/main/java/pages/HomePage.java[m
[1m+++ b/src/main/java/pages/HomePage.java[m
[36m@@ -12,5 +12,4 @@[m [mpublic class HomePage {[m
     public HomePage(WebDriver driver) {[m
         this.driver = driver;[m
     }[m
[31m-[m
 }[m
[1mdiff --git a/src/test/java/HomePageTest.java b/src/test/java/HomePageTest.java[m
[1mindex 7c927a8..af69eaf 100644[m
[1m--- a/src/test/java/HomePageTest.java[m
[1m+++ b/src/test/java/HomePageTest.java[m
[36m@@ -5,10 +5,7 @@[m [mimport org.openqa.selenium.WebDriver;[m
 import org.openqa.selenium.chrome.ChromeDriver;[m
 import org.testng.Assert;[m
 import org.testng.ITestResult;[m
[31m-import org.testng.annotations.AfterMethod;[m
[31m-import org.testng.annotations.BeforeClass;[m
[31m-import org.testng.annotations.BeforeMethod;[m
[31m-import org.testng.annotations.Test;[m
[32m+[m[32mimport org.testng.annotations.*;[m
 import pages.HomePage;[m
 import utility.ExtentReportManager;[m
 [m
[36m@@ -48,21 +45,28 @@[m [mpublic class HomePageTest {[m
         String expectedTitle = "Interview Helper - prepare to technical interview";[m
         String actualTitle = driver.getTitle();[m
 [m
[31m-        Assert.assertEquals(actualTitle, expectedTitle, "Actual title and expected title does not match, but should be.");[m
[32m+[m[32m        Assert.assertEquals(actualTitle, expectedTitle,[m
[32m+[m[32m                "The page title is incorrect. Expected: " + expectedTitle + " but found: " + actualTitle);[m
     }[m
 [m
     @AfterMethod[m
     public void tearsDown(ITestResult result) {[m
[31m-        if(result.getStatus() == ITestResult.SUCCESS){[m
[31m-            report.pass("Test passed successfully.");[m
[31m-        }[m
[31m-        if(result.getStatus() == ITestResult.FAILURE){[m
[31m-            report.fail(result.getThrowable().getMessage());[m
[31m-            report.log(Status.FAIL, result.getThrowable().getMessage());[m
[31m-        }[m
[31m-        if (driver != null) {[m
[31m-            driver.quit();[m
[32m+[m[32m        try {[m
[32m+[m[32m            if (result.getStatus() == ITestResult.SUCCESS) {[m
[32m+[m[32m                report.pass("Test passed successfully.");[m
[32m+[m[32m            }[m
[32m+[m[32m            else if (result.getStatus() == ITestResult.FAILURE) {[m
[32m+[m[32m                report.fail(result.getThrowable().getMessage());[m
[32m+[m[32m            }[m
[32m+[m[32m        } finally {[m
[32m+[m[32m            if (driver != null) {[m
[32m+[m[32m                driver.quit();[m
[32m+[m[32m            }[m
         }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @AfterClass[m
[32m+[m[32m    public void tearsDownReporter() {[m
         extentReports.flush();[m
     }[m
 }[m
