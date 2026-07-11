package com.itihas.tests;

import com.itihas.base.BaseTest;
import com.itihas.pages.LoginPage;
import com.itihas.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseTest {

    public static void main(String[] args) {

         LoginTest test = new LoginTest();
         test.setup();

        LoginPage loginPage = new LoginPage(test.driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPage productsPage = new ProductsPage(test.driver);
        System.out.println(productsPage.getTotalProducts());
        productsPage.printAllProducts();
        productsPage.addProductsBelowPrice(20);

//        driver.quit();
        test.tearDown();
    }
}