package com.itihas.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void click(By locator){
        driver.findElement(locator).click();

    }
    protected void type(By locator,String text){
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
}
