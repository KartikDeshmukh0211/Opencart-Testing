package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrderHistoryPage;
import testBase.BaseClass;

public class TC_017_OrderHistoryPage extends BaseClass{
    @Test
    public void TC_OH_001_verifyOHPNavFromMyAcc(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        accountPage.clickViewYourOrderHistory();

        OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
        Assert.assertTrue(orderHistoryPage.istxtOrderHistoryPresnt(), "Order Histroy Page is not Visible");
    }
}
