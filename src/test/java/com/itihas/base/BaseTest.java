package com.itihas.base;

import com.itihas.factory.DriverFactory;
import com.itihas.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(
                ConfigReader.get("url")
        );
    }

    public void tearDown(){

        if(driver!=null){
            driver.quit();
        }

    }
}
