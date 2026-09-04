package com.itihas.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport.html"
                    );

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + RestAssured"
            );
        }

        return extent;
    }
}