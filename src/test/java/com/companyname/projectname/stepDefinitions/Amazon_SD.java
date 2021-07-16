package com.companyname.projectname.stepDefinitions;

import com.companyname.projectname.constants.Global;
import com.companyname.projectname.pageObject.AddCartPage;
import com.companyname.projectname.pageObject.HomePage;
import com.companyname.projectname.utils.Helper;
import com.companyname.projectname.utils.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class Amazon_SD extends Helper {
    private final Logger logger = Logger.getLogger(Class.class.getName());
    private final HomePage homePage = new HomePage();
    private final AddCartPage addCartPage = new AddCartPage();

    @Given("I navigate to url")
    public void navigateToUrl() {
        navigateTo(PropertyReader.getProperty("app.URL"));
    }


    @When("I search for books {string}, match price and click on item number {int} from grid")
    public void searchForBooksAndClickOnItemNumberFromGrid(String keyWord, int itemToClick) {
        itemToClick = itemToClick - 1;
        waitForElementToBeClickable(homePage.getSearchBox());
        enterText(homePage.getSearchBox(), keyWord);
        logger.info("Entered text in search box.");
        click(homePage.getSearchButton());
        logger.info("Clicked on search button");
        List<WebElement> bookName = driver.findElements(homePage.getBookName());
        List<WebElement> priceWhole = driver.findElements(homePage.getPriceWhole());
        List<WebElement> priceFraction = driver.findElements(homePage.getPriceFraction());
        Global.EXPECTED_PRICE.set("$" + getText(priceWhole.get(itemToClick)) + "." + getText(priceFraction.get(itemToClick)));
        String actualPrice = "$" + getText(priceWhole.get(itemToClick)) + "." + getText(priceFraction.get(itemToClick));
        Assert.assertEquals("Expected and actual priced doesn't match after search", Global.EXPECTED_PRICE.get(), actualPrice);
        logger.info("Price matched before click");
        click(bookName.get(itemToClick));
        logger.info("Clicked on first book");
    }

    @Then("I match price after click")
    public void matchPriceAfterClick() {
        waitForElementToBeVisible(By.id("newBuyBoxPrice"));
        String actualPrice = getText(homePage.getPriceBeforeCart());
        Assert.assertEquals("Expected and actual priced doesn't match after search", Global.EXPECTED_PRICE.get(), actualPrice);
        logger.info("Price matched after click first book");
    }

    @When("I click on add to cart")
    public void clickOnAddToCart() {
        waitForElementToBeClickable(homePage.getAddToCartButton());
        click(homePage.getAddToCartButton());
        logger.info("Clicked on add to cart button");
    }

    @Then("I math price in cart")
    public void mathPriceInCart() {
        waitForElementToBeVisible(By.xpath("//div[@id='hlb-subcart']//span[contains(@class,'hlb-price')]"));
        String actualPrice = getText(addCartPage.getCartPriceBeforeTax());
        Assert.assertEquals("Expected and actual priced doesn't match after adding in cart", Global.EXPECTED_PRICE.get(), actualPrice);
        logger.info("Price matched in cart");
    }

    @When("I click on proceed to checkout")
    public void clickOnProceedToCheckout() {
        waitForElementToBeClickable(addCartPage.getProceedToCheckOut());
        click(addCartPage.getProceedToCheckOut());
        logger.info("Clicked on proceed to checkout button");
    }


    @Then("I match price on checkout")
    public void matchPriceOnCheckout() {
        logger.info("Works only after log in into account. I have designed next step after logging in but removed my credentials so it won't work and removed assert from next step too.");
    }
}
