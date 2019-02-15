package com.cybertek.tests;

import com.cybertek.utilities.TestBase1;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebTest extends TestBase1 {
    @Test
    public void signUp(){
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.linkText("Create an account")).click();

        Select select =new Select(driver.findElement(By.id("user_user_type")));
        select.selectByIndex(1);
        //WebElements

        fake = new Faker();
        String fakeEmail =fake.internet().emailAddress();
        WebElement user_email =driver.findElement(By.id("user_email"));
        user_email.sendKeys(fakeEmail);

        WebElement userPasswd=driver.findElement(By.id("user_password"));




    }
}
