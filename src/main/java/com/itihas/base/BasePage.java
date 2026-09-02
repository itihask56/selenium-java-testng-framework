package com.itihas.base;

import com.itihas.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    protected void click(By locator){
        waitUtils.waitForClickable(locator).click();
    }
    protected void type(By locator, String text){
        WebElement element = waitUtils.waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator){
//        return driver.findElement(locator).getText();
        return waitUtils.waitForVisible(locator).getText();
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
}
