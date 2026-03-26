package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_011_HomePageTest extends BaseClass{
    @Test(groups = {"smoke", "regression", "ui"})
    public void TC_HP_001_verifyNavigationFromShoppingCartPage(){
        HomePage homePage = new HomePage();
        String validProduct = "iMac";
        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickProductImac();

        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.clickAddToCart();
        productDisplayPage.clickLnkShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickContinueShopping();

        Assert.assertTrue(homePage.isImgHomePagePresent(), "User is not on the Home Page");
    }
}
