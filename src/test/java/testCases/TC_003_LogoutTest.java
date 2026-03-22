package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogoutPage;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_003_LogoutTest extends BaseClass{
    @Test
    public void TC_LG_001_verifyLogoutFromMyAccount(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        homePage.clickMyAccount();
        homePage.clickLogout();

        AccountLogoutPage accountLogoutPage = new AccountLogoutPage();
        Assert.assertTrue(accountLogoutPage.istxtAccountLogoutPresent(), "Account doesnt Logout");
        accountLogoutPage.clickContinue();

        Assert.assertTrue(homePage.isImgHomePagePresent(), "Not present on Homepage");
    }

    @Test
    public void TC_LG_002_verifyLogoutFromRightColumn(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        accountPage.clickLogout();

        AccountLogoutPage accountLogoutPage = new AccountLogoutPage();
        Assert.assertTrue(accountLogoutPage.istxtAccountLogoutPresent(), "Account doesnt Logout");
        accountLogoutPage.clickContinue();

        Assert.assertTrue(homePage.isImgHomePagePresent(), "Not present on Homepage");
    }
}
