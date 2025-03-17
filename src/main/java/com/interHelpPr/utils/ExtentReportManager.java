package com.interHelpPr.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    static {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
        reporter.config().setDocumentTitle("Extent report");
        reporter.config().setReportName("Simple tests");
        extentReports.attachReporter(reporter);
    }

    public static ExtentReports getInstance(){
        return extentReports;
    }
}
