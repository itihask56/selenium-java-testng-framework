package com.itihas.pages;

import com.google.common.annotations.VisibleForTesting;
import com.itihas.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //Variable
//    private WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver) {

//      this.driver = driver;
        super(driver);
    }

    //Locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    //Methods
    private void enterUsername(String user) {
//        driver.findElement(username).sendKeys(user);
          type(username,user);
    }

    private void enterPassword(String pass) {
//        driver.findElement(password).sendKeys(pass);
        type(password,pass);
    }

    private void clickLogin() {

//        driver.findElement(loginButton).click();
        click(loginButton);
    }

    public ProductsPage login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();

        return new ProductsPage(driver);
    }
}