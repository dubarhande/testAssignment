package com.companyname.projectname.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper extends DriverUtil{

    WebDriverWait wait = new WebDriverWait(driver,60);

    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected void waitForElementToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected String getText(WebElement element) {
        String value = element.getText().trim();
        return value;
    }


}
