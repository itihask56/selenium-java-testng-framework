package com.itihas.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.itihas.factory.DriverFactory;
import com.itihas.reporting.ExtentManager;
import com.itihas.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.itihas.reporting.ExtentTestManager;

public class TestListener implements ITestListener {



    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                ExtentManager.getInstance()
                        .createTest(
                                result.getTestClass().getRealClass().getSimpleName()
                                        + " :: "
                                        + result.getName()
                        );

        ExtentTestManager.setTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("TEST PASSED");
    }
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail("TEST FAILED").fail(result.getThrowable());

        try {
            if (DriverFactory.getDriver() != null) {
                String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());

                if (screenshotPath != null) {

                    ExtentTestManager.getTest()
                            .info("Screenshot captured at failure")
                            .addScreenCaptureFromPath(
                                    screenshotPath,
                                    result.getName()
                            );
                }
                ExtentTestManager.getTest()
                        .info("Screenshot captured at failure")
                        .addScreenCaptureFromPath(screenshotPath, result.getName());
            }
        } catch (Exception e) {

            ExtentTestManager
                    .getTest()
                    .warning("Unable to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}