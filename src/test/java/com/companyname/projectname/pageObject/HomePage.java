package com.companyname.projectname.pageObject;

import com.companyname.projectname.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {
    public HomePage() { PageFactory.initElements(driver, this); }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    By bookName = By.xpath("//div[@data-component-type='s-search-result']//h2/a");

    By priceWhole = By.xpath("//span[@class='a-price']//span[@class='a-price-whole']");

    By priceFraction = By.xpath("//span[@class='a-price']//span[@class='a-price-fraction']");

    @FindBy(id = "newBuyBoxPrice")
    private WebElement priceBeforeCart;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;



    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public By getBookName() {
        return bookName;
    }

    public By getPriceWhole() {
        return priceWhole;
    }

    public By getPriceFraction() {
        return priceFraction;
    }

    public WebElement getPriceBeforeCart() {
        return priceBeforeCart;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }



}
