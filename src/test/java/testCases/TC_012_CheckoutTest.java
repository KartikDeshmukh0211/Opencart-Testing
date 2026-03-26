package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_012_CheckoutTest extends BaseClass{
    @Test(groups = {"smoke", "regression", "ecommerce"})
    public void TC_CO_001_verifyEmptyShoppingCartCheckout(){
        HomePage homePage = new HomePage();
        homePage.clickCheckout();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.isCartEmpty(), "Cart is not empty");
    }
}
