package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import pageObjects.ShoppingCartPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

class TC_008_AddToCartTest extends BaseClass {
    @Test
    public void TC_ATC_001_verifyAddToCartFromDisplayPage(){
        HomePage homePage = new HomePage();
        String validProduct = "iMac";
        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickProductImac();

        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.clickAddToCart();

        Assert.assertTrue(productDisplayPage.isSuccessMessagePresent(), "Not added to cart");
        productDisplayPage.clickLnkShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.istxtShoppingCartPresent(), "Shopping Cart is not displayed");
    }
    
    @Test
    public void TC_ATC_002_verifyAddToCartFromWishList(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();
        
        homePage.clickCompanyLogo();
        String validProduct = "iMac";
        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickProductImac();

        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.clickAddToWishList();

        homePage.clickWishList();

        WishListPage wishListPage = new WishListPage();
        wishListPage.clickAddToCart();

        Assert.assertTrue(wishListPage.isSuccess(), "Failed to perform action");
        wishListPage.clickLnkShoppingCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.istxtShoppingCartPresent(), "Shoping cart is not present");
    }
}