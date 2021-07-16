package com.companyname.projectname.utils;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static com.companyname.projectname.constants.Global.CONFIG_PATH;

public class PropertyReader {

    public static String getProperty(String key) {
        String value = new String();
        try {
            Properties properties = new Properties();
            File file = new File(CONFIG_PATH);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            value = properties.getProperty(key);
        } catch (Exception e) {
            Assert.fail("Error in reading property from config file and key name is -- " + key);
        }
        return value;
    }
}
