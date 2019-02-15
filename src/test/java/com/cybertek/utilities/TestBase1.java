package com.cybertek.utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase1 {

    public WebDriver driver;
    public String url=" https://code.org/";
    public Faker fake;

    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new  ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fake=new Faker();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
    }


    public  class FAKER {
    }
}
