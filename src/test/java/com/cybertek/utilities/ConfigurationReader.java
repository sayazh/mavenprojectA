package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
        String path ="configuration.properties";
        try {

            //java cannot read files directly, it needs inputstream to read files
            //inputstream takes the location ofthe file as a constructor
            FileInputStream fileInputStream = new FileInputStream(path);

            //Properties is used to read speciafically properties files, files with ey value pairs
            properties = new Properties();

           // file contents are load to properties from the inputstream
            properties.load(fileInputStream);

           //all input streams must be closed
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String property){
        return properties.getProperty(property);
    }
}
