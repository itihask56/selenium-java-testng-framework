package com.itihas.tests;

import com.itihas.base.BaseTest;
import com.itihas.pages.LoginPage;
import com.itihas.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public  void loginTest() {


         setup();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPage productsPage = new ProductsPage(driver);
        System.out.println(productsPage.getTotalProducts());
        productsPage.printAllProducts();
        productsPage.addProductsBelowPrice(20);

//        driver.quit();
        tearDown();
    }
}