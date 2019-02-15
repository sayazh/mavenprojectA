package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AmazonSearch {
    public static void main(String[] args) {
        //open browser
        //go to amazon
        //enter search term and submit
        //verify search box still contains the same search term
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        String searchTerm = "Lacosta";
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lacosta"+Keys.ENTER);

        //WebElement searchButton = driver.findElement(By.className("nav-input"));

        //searchButton.click();
        String actual =driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");


        if(searchTerm.equals(actual)){
            System.out.println("PASS");
            System.out.println("search box still contains the search term");
        } else{
            System.out.println("FAIL");
            System.out.println("Expected result: "+"Lacosta");
            System.out.println("Actual result: "+searchTerm);
        }
    }
}
