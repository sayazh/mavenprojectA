package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
Step 1: open a Chrome browser
Step 2: go to the URL "https://houston.craigslist.org/"
Step 3: insert 20 s implicitly wait command in case you have a slow connection
Step 4: Create a Web element to locate and click on the link "motorcycles" and click it on
Step 5: Create a Web element to locate and fill the "miles" text box by "150"
Step 6: Create a Web element to locate and fill the "ZIP" text box by "77498"
Step 7: Create a Web element to locate and fill the "year" text box by "2005"
Step 8 : Create a Web element to locate and fill the "engine displacement" text box by "1000"
 */
import java.util.concurrent.TimeUnit;

public class MentoringSessionCraigslist {
    WebDriver driver;
    @BeforeMethod
    public void setUpmethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
        public void testHarleyYear(){
            driver.get("https://houston.craigslist.org");
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            WebElement motorcycleLink =driver.findElement(By.linkText("motorcycles"));
            motorcycleLink.click();

            WebElement miles =driver.findElement(By.name("search_distance"));
            miles.sendKeys("150");

            WebElement zipCode =driver.findElement(By.name("postal"));
            zipCode.sendKeys("77498");

            WebElement minYearBox =driver.findElement(By.name("min_auto_year"));
            minYearBox.sendKeys("2005");

            WebElement engineDisplacement =driver.findElement(By.name("min_engine_displacement_cc"));
        engineDisplacement.sendKeys("1000");
        //Step 9: Create a Web element to locate and click to navigate into the page of first motorcycle

        // Step 10: Locate the text including the year of the motorcycle

        // Step 11: Get the text including the year of the motorcycle and parse it into int

        //Step 12: check if the year is greater or equal to 2005 by assertTrue

    }
    }


