package com.cybertek.tests;

/*
Project Name : Hunting Harley Davidson 1200 at Craigslist
Step 1: open a Chrome browser
Step 2: go to the URL "https://houston.craigslist.org/"
Step 3: insert 20 s implicitly wait command in case you have a slow connection
Step 4: Create a Web element to locate and click on the link "motorcycles" and click it on
Step 5: Create a Web element to locate and fill the "miles" text box by "30"
Step 6: Create a Web element to locate and fill the "ZIP" text box by "77498"
Step 7: Create a Web element to locate and fill the "min price" text box by "1500"
Step 8: Create a Web element to locate and fill the "make and model " text box by "harley davidson 1200"
Step 9: Create a Web element to locate and get the total number of  "harley davidson 1200" models in String format
Step 10: Convert the the total number of  "harley davidson 1200" models from String to int
Step 11: Create a Web element to locate and click to navigate into the page of first motorcycle
Step 12: Create an ArrayList to store the prices of motorcycles in String format
Step 13: Loop through all pages by clicking on the next link and collect price data and store into the ArrayList
Step 14: Print out the list of the prices of all motorbikes
Step 15: Create an int minPrice and loop through the ArrayList to find and assign the minimum price
        note that the prices are in String format and must be converted into int
Step 16: Print out the min price
Step 17: Loop through all pages by navigating back to find the page where the motorcycle with min price is and
        locate the reply button and click it on  and then locate and  get the phone number and print it out
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HuntingHarley {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://houston.craigslist.org/");
 // Step 4: Create a Web element to locate and click on the link "motorcycles" and click it on

        WebElement motorcycleLink = ((ChromeDriver) driver).findElementByLinkText("motorcycles");
        motorcycleLink.click();

        //5: Create a Web element to locate and fill the "miles" text box by "30"
        WebElement mile =((ChromeDriver) driver).findElementByName("search_distance");
        mile.sendKeys("30");

        // 6: Create a Web element to locate and fill the "ZIP" text box by "77498"
        WebElement zipCode =((ChromeDriver) driver).findElementByName("postal");
  zipCode.sendKeys("77498");

        //7: Create a Web element to locate and fill the "min price" text box by "1500"
         WebElement minPriceBox =((ChromeDriver) driver).findElementByName("min_price");
         minPriceBox.sendKeys("1500");

         //Step 8: Create a Web element to locate and fill the "make and model " text box by "harley davidson 1200"
         WebElement modelBox =((ChromeDriver) driver).findElementByName("auto_make_model");
         modelBox.sendKeys("harley davidson 1200");
         modelBox.submit();

         //Step 9: Create a Web element to locate and get the total number of  "harley davidson 1200" models in String format

        WebElement totalCountBox =((ChromeDriver) driver).findElementByClassName("totalcount");
        System.out.println(totalCountBox.getText());

        //Step 10: Convert the the total number of  "harley davidson 1200" models from String to int

           int totalCountNum =Integer.valueOf(totalCountBox.getText());

           //Step 11: Create a Web element to locate and click to navigate into the page of first motorcycle
        WebElement firstPage =((ChromeDriver) driver).findElementByPartialLinkText("1200");
        firstPage.click();

        //12: Create an ArrayList to store the prices of motorcycles in String format

        ArrayList<String> prices = new ArrayList<String>();

        //Step 13: Loop through all pages by clicking on the next link and collect price data and store into the ArrayList
        for(int i=1; i<=totalCountNum; i++){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement priceBox = ((ChromeDriver) driver).findElementByClassName("price");
            prices.add(priceBox.getText());
            WebElement nextLink = ((ChromeDriver) driver).findElementByClassName("next");
            nextLink.click();
        }
        //Step 14: Print out the list of the prices of all motorbikes
        System.out.println(prices.toString());

        //Step 15: Create an int minPrice and loop through the ArrayList to find and assign the minimum price
        //        note that the prices are in String format and must be converted into int

        int minPrice = 500000;
        for (int i=0; i<prices.size(); i++){
            if(Integer.valueOf(prices.get(i).replace("$", "").trim())< minPrice){
                  minPrice =Integer.valueOf(prices.get(i).replace("$", "").trim());
            }
        }
        //Step 16: Print out the min price
        System.out.println("min price is : $" + minPrice);

        //Step 17: Loop through all pages by navigating back to find the page where the motorcycle with min price is and
        //        locate the reply button and click it on  and then locate and  get the phone number and print it out

        for (int i = 1; i <totalCountNum ; i++) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement priceBox2 = ((ChromeDriver) driver).findElementByClassName("price");
            if(Integer.valueOf(priceBox2.getText().replace("$", "").trim())== minPrice){
                WebElement replyBox = ((ChromeDriver) driver).findElementByCssSelector("button.reply_button.js-only");
            replyBox.click();
            WebElement telBox = ((ChromeDriver) driver).findElementByClassName("reply-tel-number");
                System.out.println(telBox.getText());
                return;
            }
            driver.navigate().back();

        }
    }
}