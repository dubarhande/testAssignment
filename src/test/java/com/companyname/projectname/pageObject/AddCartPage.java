package com.companyname.projectname.pageObject;

import com.companyname.projectname.utils.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage extends Helper {
    public AddCartPage() { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//div[@id='hlb-subcart']//span[contains(@class,'hlb-price')]")
    private WebElement cartPriceBeforeTax;

    @FindBy(id = "hlb-ptc-btn")
    private WebElement proceedToCheckOut;

    public WebElement getCartPriceBeforeTax() {
        return cartPriceBeforeTax;
    }

    public WebElement getProceedToCheckOut() {
        return proceedToCheckOut;
    }
}
