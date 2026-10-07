package com.itihas.factory;

import com.itihas.utils.ConfigReader;
import com.itihas.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LoggerUtil.getLogger(DriverFactory.class);
    public static void initDriver() {

        String browser = ConfigReader.get("browser");
        log.info("Initializing browser: {}", browser);

        WebDriver webDriver;

        switch (browser.trim().toLowerCase()) {

            case "chrome":
                log.info("Launching Chrome browser");
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);

                options.setExperimentalOption("prefs", prefs);

                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-features=PasswordLeakDetection");
                options.addArguments("--disable-features=PasswordManagerOnboarding");

                // Detect CI environment
                boolean isCI = "true".equalsIgnoreCase(System.getenv("CI"));
                log.info("CI environment: {}", isCI);

                if (isCI) {
                    log.info("CI environment detected. Running Chrome in headless mode.");


                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--window-size=1920,1080");
                } else {
                    log.info("Local environment detected. Running Chrome normally.");
                }

                webDriver = new ChromeDriver(options);
                break;

            case "edge":
                log.info("Launching Edge browser");
                webDriver = new EdgeDriver();
                break;

            case "firefox":
                log.info("Launching Firefox browser");
                webDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.set(webDriver);
        log.info(
                "Driver initialized successfully | Thread: {} | Driver: {}",
                Thread.currentThread().getId(),
                webDriver.hashCode()
        );
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
            log.info(
                    "Closing Driver | Thread: {} | Driver: {}",
                    Thread.currentThread().getId(),
                    driver.get().hashCode()
            );

            driver.remove();
            log.info("Driver removed from ThreadLocal");
        }
    }
}
