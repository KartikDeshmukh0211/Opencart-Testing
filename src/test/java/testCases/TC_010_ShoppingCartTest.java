package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_010_ShoppingCartTest extends BaseClass{
    @Test
    public void TC_SC_001_verifyShoppingCartFromSuccessMsg(){
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
        Assert.assertTrue(shoppingCartPage.istxtShoppingCartPresent(), "Shoping cart is not present");
    }
}
