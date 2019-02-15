package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {

    @Test
    public void test() {
        driver.get("https://www.amazon.com/");

        WebElement signIn = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
        //moving the mouse on top of the given element
        actions.moveToElement(signIn).perform();

        driver.findElement(By.xpath("//span[.='Your hearts']")).click();
        Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }
        @Test
        public void test2(){
            driver.get("https://www.amazon.com");
            WebElement help = driver.findElement(By.xpath("(//a[.='Help'])[2]"));

            actions.moveToElement(help).perform();
        }

    }

