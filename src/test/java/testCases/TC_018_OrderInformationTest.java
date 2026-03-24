package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrderHistoryPage;
import pageObjects.OrderInformationPage;
import testBase.BaseClass;

public class TC_018_OrderInformationTest extends BaseClass{
    @Test
    public void TC_OI_001_verifyDetailsOfOrderInformationPage(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        accountPage.clickOrderHistory();

        OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
        orderHistoryPage.clickViewOrderBtn();

        OrderInformationPage orderInformationPage = new OrderInformationPage();
        Assert.assertTrue(orderInformationPage.istxtOrderHistoryPresent(), "Order Information Page is not present");

        // Validation of order detials are remaining.....

        // "1. User should be taken to 'Order Information' page
        // 2. Correct Order details should be displayed for the below: 
        // Order Details section - Order ID, Payment Method, Date Added and  Shipping Method
        // Payment Address and  Shipping Address
        // Product Name, Model, Quantity, Price, Total, Sub-Total, Flat Shipping Rate and Total
        // Order History, Date Added, Status and Comment"


    }
}
