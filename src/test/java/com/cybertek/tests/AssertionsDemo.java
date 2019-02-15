package com.cybertek.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
    @Test
    public void test1(){
        String a ="A";
        String b ="A";

        Assert.assertEquals(a,b); //comparing a to b
    }

    @Test
    public void test2(){
        String a = "A";
        String b= "AAA";
        Assert.assertEquals(a,b); //comparing a to b, first param is actual second is expected
    }
    @Test
    public void test3(){
        boolean bool =1==1;
        Assert.assertTrue(bool);
    }
   @Test
    public void test4(){
        String a = "aDFD";
        String b= "sbs";

        Assert.assertTrue(a.contains(a));
         System.out.println("DONE");

   }
   @Test
    public void test5(){
        String str ="ap";
        String b = "apple";
        Assert.assertTrue(b.contains(str), b+"should have contained "+str);
   }
}
