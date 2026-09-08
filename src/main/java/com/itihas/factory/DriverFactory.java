package com.itihas.factory;

import com.itihas.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        WebDriver webDriver;

        switch (browser.trim().toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);

                options.setExperimentalOption("prefs", prefs);

                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-features=PasswordLeakDetection");
                options.addArguments("--disable-features=PasswordManagerOnboarding");

                webDriver = new ChromeDriver(options);
                break;

            case "edge":
                webDriver = new EdgeDriver();
                break;

            case "firefox":
                webDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.set(webDriver);
    }

    public static WebDriver getDriver() {

        if (driver.get() == null) {
            throw new RuntimeException(
                    "Driver is not initialized for current thread"
            );
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}
