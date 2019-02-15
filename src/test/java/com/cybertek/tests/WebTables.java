package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {

    // @Test
    public void printWholeTable() {
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }

    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.id("ctl00_MainContent_password"));
        passWord.sendKeys("test");
        //Click on login
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        driver.manage().window().maximize();
    }

    @Test
    public void printHeaderNames() {
        login();
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRows() {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        for (WebElement header : allRows) {
            System.out.println(header.getText());
        }

        System.out.println("Printing a row: "+3);
        System.out.println(allRows.get(2).getText()+" | ");
    }
    /*
    print the size : columns and rows in a table
     */
    @Test
    public void printTableSize() {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("number of rows: " + allRows.size());
        List<WebElement> allColumnHeaders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));

        System.out.println("umber of columns: " + allColumnHeaders.size());
        /*
        print a row without using a list
         */
    }
        @Test
        public void printRows2(){
        login();
        WebElement row =driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
            System.out.println("The fifth row: "+row.getText());

        }
        /*
        print all cells in a row whose index is given in the xpath
         */
        @Test
    public void printAllCellsInOneRow(){
        login();
        List<WebElement> cells=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

            for (WebElement cell: cells) {
                System.out.print(cell.getText()+" | ");

            }

        }
        /*
        print by coordinates: based on row and column number
         */
        @Test
    public void printByCoordinates(){
            login();
            WebElement cell =driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[2]"));
            System.out.println("Person name on the sixth row and second column is: "+cell.getText());
        }

        public WebElement getCell(int row, int col){
            String xpath ="//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";
            return driver.findElement(By.xpath(xpath));
        }
        /*
        print all the values in a single column
         */
        @Test
    public void printColumn() {
            login();
            int i = 1;
            List<WebElement> namesFromTheTables = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
            for (WebElement name : namesFromTheTables) {
                System.out.println("Name " + i + ": " + name.getText());
                i++;
            }
        }
            /*
            find the select checkbox for a given name
             */
            @Test public void selectCheckBox(){
                login();
                WebElement checkBox =driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));
                System.out.println("Checkbox has been selected: "+checkBox.isSelected());
                checkBox.click();
                System.out.println("Checkbox has been selected: "+checkBox.isSelected());
            }
            /*
            verify that name 'Mark Smith' exists in the names column
            verify that city 'Whitestone, British' exists in the cities column
             */
            @Test
    public void  test(){
                login();
               int nameIndex =getColumnIndex("Name");
                System.out.println(nameIndex);
                List<WebElement> allNames =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));
               boolean found =false;
                for (int i = 0; i <allNames.size() ; i++) {
                    if(allNames.get(i).getText().equals("Mark Smith")){
                        found=true;
                        //pass
                        //break
                        break;
                    }
                }
                Assert.assertTrue(found);
                found =false;
                int cityIndex =getColumnIndex("City");

                List<WebElement> allCities =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody/tr/td["+cityIndex+"]"));
                for (int i = 0; i <allCities.size(); i++) {
                    if(allCities.get(i).getText().equals("Whitestone, British")){
                        found=true;
                        break;
                    }
                }
                Assert.assertTrue(found);
            }
            /*
            gets a column name as a parameters
            return index of the column name
             */

            public int getColumnIndex(String column){
                List<WebElement> allHeader =driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
                for (int i = 0; i <allHeader.size() ; i++) {
                    if (allHeader.get(i).getText().equals(column)) {
                        return i+1;
                    }
                }
                return 0;
            }
        }

