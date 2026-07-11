package com.itihas.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsChearerThanTwenty {
    public static void main(String[] args) throws InterruptedException{
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



       List<WebElement> totalProducts = driver.findElements(By.className("inventory_item"));
        System.out.println(totalProducts.size());


        List<WebElement>cheapProducts = new ArrayList<>();
         List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));


        for(int i=0;i<totalProducts.size();i++){
            double item_price = Double.parseDouble(productPrices.get(i).getText().replace("$",""));

            if(item_price<20){
                cheapProducts.add(totalProducts.get(i));

            }


        }
      for (int i=0;i<cheapProducts.size();i++){

          String name = cheapProducts.get(i).findElement(By.className("inventory_item_name")).getText();
          String price = cheapProducts.get(i).findElement(By.className("inventory_item_price")).getText();
          cheapProducts.get(i).findElement(By.tagName("button")).click();
          System.out.println(name+" -> "+ price);


      }

        int expected = cheapProducts.size();

        int actual = Integer.parseInt(
                driver.findElement(By.className("shopping_cart_badge"))
                        .getText()
        );

        if(expected == actual){

            System.out.println("PASS");
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Itihas");
            driver.findElement(By.id("last-name")).sendKeys("Verma");
            driver.findElement(By.id("postal-code")).sendKeys("805127");
             wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
            WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
            finishButton.click();

        }else{

            System.out.println("FAIL");

        }

        driver.quit();
    }
}
