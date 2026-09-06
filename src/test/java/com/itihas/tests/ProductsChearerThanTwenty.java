package com.itihas.tests;

import com.itihas.base.BaseTest;
import com.itihas.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsChearerThanTwenty extends BaseTest {
    @Test
    public void verifyProductCheaperThanTwenty() {
        System.out.println(
                "ProductsChearerThanTwenty Thread : "
                        + Thread.currentThread().getId()
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");


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

    }
}
