package com.companyname.projectname.constants;

public class Global {

    public static String CONFIG_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    public static String DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/";

    public static ThreadLocal<String> EXPECTED_PRICE = new ThreadLocal<>();
}
