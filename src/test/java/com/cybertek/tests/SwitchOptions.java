package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchOptions {
    WebDriver driver;
    @BeforeMethod
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");
    }
    @AfterMethod
        public void leanUp(){
        driver.quit();
    }
        @Test
        public void switchByEelement() {
            WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
            // switch to iframe
            driver.switchTo().frame(iframe);
            driver.findElement(By.tagName("body")).sendKeys("HELLO WORLD!!!");
            // driver.get("https://the-internet.herokuapp.com/nested_frames");
        }

    @Test
    public void switchById() {
        // switch to iframe
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("body")).sendKeys("HELLO WORLD!!!");
    }
    @Test
    public void switchByIndex(){
        // switch to iframe
        driver.switchTo().frame(0);
        driver.findElement(By.tagName("body")).sendKeys("HELLO WORLD!!!");

    }
}
