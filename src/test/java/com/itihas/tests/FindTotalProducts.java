package com.itihas.tests;

import com.itihas.base.BaseTest;
import com.itihas.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTotalProducts extends BaseTest {
    @Test
    public void verifyTotalProducts() {
        System.out.println(
                "FindTotalProducts Thread : "
                        + Thread.currentThread().getId()
        );
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        List<WebElement> products =
                driver.findElements(By.className("inventory_item"));

        System.out.println("Total Products : " + products.size());

//        double maxPrice = 0;
        double minPrice = 1000;
//        String maxProduct = "";
        String minProduct = "";

        for(int i = 0; i < products.size(); i++){

            String name =
                    driver.findElements(By.className("inventory_item_name"))
                            .get(i)
                            .getText();

            double price =
                    Double.parseDouble(
                            driver.findElements(By.className("inventory_item_price"))
                                    .get(i)
                                    .getText()
                                    .replace("$","")
                    );

            System.out.println(name + " -> $" + price);

//            if(price > maxPrice){
//
//                maxPrice = price;
//                maxProduct = name;
//
//            }
            if(price<minPrice){
                minPrice = price;
                minProduct = name;
            }
        }

//        System.out.println("Most Expensive : " + maxProduct);
//        System.out.println("Price : $" + maxPrice);



        System.out.println("\nCheapest Product : " + minProduct);
        System.out.println("Price : $" + minPrice);

// Find the cheapest product card and click its Add to Cart button
        for (WebElement product : products) {

            String name = product.findElement(By.className("inventory_item_name")).getText();

            if (name.equals(minProduct)) {

                // Click Add to Cart button inside this product card
                product.findElement(By.tagName("button")).click();

                // Verify cart badge
                String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();

                if (cartCount.equals("1")) {
                    System.out.println("PASS: Cart count is 1");
                } else {
                    System.out.println("FAIL: Expected 1 but found " + cartCount);
                }

                break;
            }
        }



    }
}
