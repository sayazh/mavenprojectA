package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1 step. We have to locate an element with tag select
        WebElement selectElement = driver.findElement(By.id("dropdown"));

        // 2 step. create select object using the webElement
        Select list = new Select(selectElement);


        //print the selected option
        String selectedOption =list.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        List<WebElement> options =list.getOptions();
        System.out.println("options.size= "+options.size());

        for(WebElement option : options){
            System.out.println(option.getText());
        }
      // 1.select different options
        //1.by visible text
        list.selectByVisibleText("Option 1");
        System.out.println("Selected option: "+list.getFirstSelectedOption().getText());

       // 2.by visible index, count is 0 based
        list.selectByIndex(2);
        System.out.println("Selected option by index: "+list.getFirstSelectedOption().getText());

        // 3. by value attribute
        list.deselectByValue("1");
        System.out.println("Selected option: "+list.getFirstSelectedOption().getText());






    }
}
