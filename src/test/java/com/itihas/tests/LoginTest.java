package com.itihas.tests;

import com.itihas.pages.LoginPage;
import com.itihas.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPage productsPage = new ProductsPage(driver);
        System.out.println(productsPage.getTotalProducts());
        productsPage.printAllProducts();
        productsPage.addProductsBelowPrice(20);

        driver.quit();
    }
}