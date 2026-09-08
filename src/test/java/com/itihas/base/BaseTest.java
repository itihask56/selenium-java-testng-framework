package com.itihas.base;

import com.itihas.factory.DriverFactory;
import com.itihas.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(
                ConfigReader.get("url")
        );
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}
