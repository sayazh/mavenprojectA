package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

    @Test
    public void test1(){
        System.out.println("starting");
        Assert.assertTrue(false);
        System.out.println("done");
    }

    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert();

        System.out.println("starting");
        softAssert.assertTrue(false);
        System.out.println("done");

        softAssert.assertEquals(1,1);
        softAssert.assertAll();
    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("starting");

        softAssert.assertTrue(false);
        Assert.assertTrue(false);
        System.out.println("done");
        softAssert.assertAll();
    }
}
