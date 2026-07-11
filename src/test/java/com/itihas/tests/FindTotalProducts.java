package com.itihas.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTotalProducts {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-features=PasswordManagerOnboarding");

        WebDriver driver = new ChromeDriver(options);
//

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

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

        driver.quit();



    }
}
