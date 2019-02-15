package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/*
go to https://the-internet.herokuapp.com/upload
upload file
click upload
verify text uploaded
 */
public class FileUploadTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(3000);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String path ="C:\\Users\\admin\\Downloads\\test.txt";
        chooseFile.sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }

    
}
