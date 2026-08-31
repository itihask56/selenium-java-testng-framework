package com.itihas.pages;

import com.itihas.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    //variable
    private WebDriverWait wait;

    //constructor
   public ProductsPage(WebDriver driver){

       super(driver);
       this.wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private By inventory_items = By.className("inventory_item");
    private By inventory_item_name = By.className("inventory_item_name");
    private By inventory_item_price = By.className("inventory_item_price");
    private By shopping_cart_link = By.className("shopping_cart_link");
    private By shopping_cart_badge = By.className("shopping_cart_badge");
    private By button = By.tagName("button");
    private By checkout = By.id("checkout");
    private By first_name = By.id("first-name");
    private By last_name = By.id("last-name");
    private By postal_code = By.id("postal-code");
    private By finish = By.id("finish");
    private By continu = By.id("continue");



    //methods

    private List<WebElement> getProducts(){

//        return driver.findElements(inventory_items);
        return findAll(inventory_items);

    }

    public int getTotalProducts(){
         return getProducts().size();
    }
    public void printAllProducts(){
//        List<WebElement> allProduct = driver.findElements(inventory_item_name);
        List<WebElement>allProduct = findAll(inventory_item_name);
         for(int i=0;i<allProduct.size();i++){
             System.out.println(allProduct.get(i).getText());
         }
    }
    public void addProductsBelowPrice(double price){


        List<WebElement> productPrices = findAll(inventory_item_price);
        List<WebElement>cheapProducts = new ArrayList<>();
        List<WebElement> products = findAll(inventory_items);

        for(int i=0;i<productPrices.size();i++){
            double itemsPrice =Double.parseDouble(productPrices.get(i).getText().replace("$",""));
            if (itemsPrice<price){
                cheapProducts.add(products.get(i));


            }
        }
        System.out.println("No. of cheap products"+cheapProducts.size());

        for(WebElement product : cheapProducts){

            product.findElement(button).click();
//            product.click(button);


        }

        int expected = cheapProducts.size();

        int actual = Integer.parseInt(driver.findElement(shopping_cart_badge).getText());

        if(expected == actual){

            System.out.println("PASS");
            driver.findElement(shopping_cart_link).click();
            driver.findElement(checkout).click();
            driver.findElement(first_name).sendKeys("Itihas");
            driver.findElement(last_name).sendKeys("Verma");
            driver.findElement(postal_code).sendKeys("805127");
            wait.until(ExpectedConditions.elementToBeClickable(continu)).click();
            WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(finish));
            finishButton.click();

        }else{

            System.out.println("FAIL");

        }


    }



}
