package com.itihas.utils;

import com.itihas.factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(String testName) {

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyyMMdd_HHmmss"
                                )
                        );

        String fileName =
                testName
                        + "_"
                        + timestamp
                        + ".png";

        String filePath =
                "test-output/screenshots/"
                        + fileName;

        File source =
                ((TakesScreenshot)
                        DriverFactory.getDriver())
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        try {

            File screenshotDir =
                    new File("test-output/screenshots");

            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            FileUtils.copyFile(
                    source,
                    new File(filePath)
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to save screenshot",
                    e
            );
        }

        // Relative path for Extent Report
        return "screenshots/" + fileName;
    }
}