package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_009_WishListTest extends BaseClass{
    @Test(groups = {"regression", "ecommerce"})
    public void TC_WL_001_verifyWishListFromRelatedProduts(){
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
        List<WebElement> allRelatedProducts = productDisplayPage.getRelatedProducts();

        if(allRelatedProducts.size() == 0){
            Assert.fail("No realted Products....");
        }

        allRelatedProducts.get(0).click();
        productDisplayPage.clickAddToWishList();
        Assert.assertTrue(productDisplayPage.isSuccessMessagePresent(), "Failed to perform action");

        productDisplayPage.clickLnkWishList();

        WishListPage wishListPage = new WishListPage();

        Assert.assertTrue(!wishListPage.isWishListEmpty(), "WishList is Empty");
    }
}
