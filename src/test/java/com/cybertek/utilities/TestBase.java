package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;


    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
        softAssert.assertAll();
        actions = new Actions(driver);
    }
}
