package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
    @Test(groups = {"smoke", "regression", "auth"})
    public void TC_LF_001_verifyLoginWithValidCredentials(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isReturningCustomer(), "Login page not loaded.....");
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        Assert.assertTrue(accountPage.istxtMyAccountPresent(), "My Account is not present");
    }
}
