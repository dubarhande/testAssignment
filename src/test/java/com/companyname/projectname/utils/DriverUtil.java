package com.companyname.projectname.utils;

import com.companyname.projectname.constants.Global;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtil {
    public static WebDriver driver;

    protected static void  openBrowser(String browserToUse) {
        switch (browserToUse.toLowerCase()) {
            case "chrome":
                openChromeBrowser();
            case "firefox":
                // write TODO openFirefoxBrowser();
        }
    }

    private static WebDriver openChromeBrowser() {
        try {
            System.setProperty("webdriver.chrome.driver", Global.DRIVER_PATH + "/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            Assert.fail("Open chrome browser failed.");
        }
        return driver;
    }

    protected static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            Assert.fail("Close browser failed.");
        }
    }
}
