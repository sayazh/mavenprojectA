package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExplicitWaitTwo {

    @Test
    public void test() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //click on a button
        Driver.getDriver().findElement(By.tagName("button")).click();
        //locate text
        WebElement text = Driver.getDriver().findElement(By.cssSelector("#finish h4"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(text));


        System.out.println(text.getText());
        //verify text is displayed
        Assert.assertTrue(text.isDisplayed());
    }
    @Test
    public void test2(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //click on a button
        Driver.getDriver().findElement(By.tagName("button")).click();
        //locate text
        WebElement text = Driver.getDriver().findElement(By.cssSelector("#finish h4"));


        //TODO wait until Loading message disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[.='Loading... ']")));

        System.out.println(text.getText());
        //verify text is displayed
        Assert.assertTrue(text.isDisplayed());
    }
}
