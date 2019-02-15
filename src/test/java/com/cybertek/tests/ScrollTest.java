package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class ScrollTest extends TestBase {
   @Test
    public void test(){
       driver.get("https://youtube.com");

       actions.sendKeys(Keys.PAGE_DOWN).perform();
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       actions.sendKeys(Keys.ARROW_DOWN).perform();


   }
}
