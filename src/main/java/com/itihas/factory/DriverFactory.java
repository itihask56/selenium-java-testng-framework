package com.itihas.factory;

import com.itihas.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(){
        String browser = ConfigReader.get("browser");

        switch (browser.trim().toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
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
