package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/*
 1. open browser
2.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
3. Randomly select days of the week. As soon as you check any day, print the name of the
day and uncheck immediately. After you check and uncheck Friday for the third time, exit the program
 */
public class Days {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
    }
}
