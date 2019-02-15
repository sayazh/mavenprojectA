package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/*
open browser
2.  go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton
3. verify that Football is selected by default and all others are not selected.
4. Select a random sport
5. Verify that all other options are not selected
 */
public class Sports {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        WebElement footballButton = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));

        System.out.println("DEFAULT");
        System.out.println("Football button: "+footballButton.isSelected());

        WebElement baseballButton = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        WebElement basketballButton = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        WebElement hockeyButton = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        WebElement soccerButton = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        WebElement waterPolo = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));

        System.out.println(" ---- Checking other options ---- ");

        if(!baseballButton.isSelected()) {
            System.out.println("Baseball Button is not selected");
        } else {
            System.out.println("Baseball Button is been selected");
        }
        if(!basketballButton.isSelected()) {
            System.out.println("Basketball Button is not selected");
        } else{
            System.out.println("Basketball Button is selected");
        }
        if(!hockeyButton.isSelected()){
            System.out.println("Hockey button is not selected");
        } else{
            System.out.println("Hockey button has been choosen");
        }
        if(!soccerButton.isSelected()){
            System.out.println("Soccer button is not selected");
        } else{
            System.out.println("Soccer button has been selected");
        } if (!waterPolo.isSelected()){
            System.out.println("WaterPolo button is not selected");
        } else{
            System.out.println("WaterPolo button is selected");
        }


    }
}
