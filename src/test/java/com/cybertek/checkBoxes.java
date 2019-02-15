package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBoxes {
    public static void main(String[] args) {

   // setting driver path for chrome using the webdriver manager
        //
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input = driver.findElement(By.id("email"));

        input.sendKeys("someemail@somemail.com"+ Keys.ENTER);

        //input.submit(); just like hitting enter

         String expected ="Your e-mail's been sent!";
         String actual =driver.findElement(By.id("content")).getText();
        System.out.println(actual);

        if(actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actual = "+actual);
            System.out.println("expected = "+expected);
        }


    }

}
