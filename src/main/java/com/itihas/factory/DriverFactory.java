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

    public static WebDriver getDriver(){
        String browser = ConfigReader.get("browser");

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

                return new ChromeDriver(options);
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();


            default:throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }
    }
}
