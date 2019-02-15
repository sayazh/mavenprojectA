package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyTextDisappearTest extends TestBase {

    @Test
    public void verify1(){
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        WebElement text = driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());
        Assert.assertTrue(text.isDisplayed());
        WebElement button = driver.findElement(By.xpath("//button[.='Toggle Hide and Show']"));
        button.click();
        Assert.assertFalse(text.isDisplayed());
    }
    @Test
    public void verify2(){
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");
        driver.switchTo().frame("iframeResult");
    WebElement text1 =driver.findElement(By.xpath("//body/p"));
        System.out.println(text1.getText());
        Assert.assertTrue(text1.isDisplayed());
        WebElement button =driver.findElement(By.xpath("//body/button"));
        button.click();

        try {
            Assert.assertFalse(text1.isDisplayed());
        } catch (StaleElementReferenceException e){
            System.out.println("We took care of an exception");
        }
        Assert.assertFalse(elementDisplayed(By.xpath("//body/b")));
    }

    /**
     * takes locator and returns if element
     * matching this locator exists
     * @param by
     * @return
     */
    public boolean elementDisplayed(By by){
        //try find it
        //if cant find it, return false
        try{
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public boolean elementDisplayeds(By by){
        return driver.findElements(by).isEmpty();
    }
}
