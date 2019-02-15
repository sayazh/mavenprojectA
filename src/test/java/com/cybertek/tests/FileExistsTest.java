package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static java.nio.file.Files.*;

public class FileExistsTest {

    @Test
    public void test() {
        // get the current folder
        String current = System.getProperty("user.dir");
        System.out.println(current);

        // get the user folder
        String userFolder = System.getProperty("user.home");
        System.out.println(userFolder);

        String path = userFolder + "\\Downloads\\test.txt";

        System.out.println(path);

        // Files.exists(Paths.get()  : returns true if file exists in the parameter provided


        Assert.assertTrue(exists(Paths.get(path)));
    }
}