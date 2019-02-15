package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;



public class TabsExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/windows");
    }
    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    /*
    Test case:
    go to http://the-internet.herokuapp.com/windows
    click on click “Click here”

    verify that new title is “New window”
    verify that new title is not “The internet”
     */
    @Test
    public void changeTab(){
        System.out.println(driver.getWindowHandles().size());
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("************************");
        for(String handle :windowHandles){
            System.out.println(handle);
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
            if(driver.getTitle().equals("New Window")){
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), "New Window" );
        Assert.assertNotEquals( driver.getTitle(),"The Internet");
    }
/*
 go tot this website : https://www.w3schools.com/html/
 click on Try it Yourself
 verify the url of the new tab contains "default"

 */
    @Test
    public void changeTab2(){
        driver.get("https://www.w3schools.com/html/");
        driver.findElement(By.linkText("Try it Yourself")).click();

        //title of the second Try it Editor v3.6
        // get all handles
        // switch 1 by one
        // if the title is the right, break the loop
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("Trying Editor v3.6")){
                break;
            }

        }
        Assert.assertTrue(driver.getCurrentUrl().contains("default"));
        System.out.println(driver.getWindowHandles().size());
        driver.close();

        System.out.println(driver.getWindowHandles().size());


    }

}
