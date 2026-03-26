package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_013_MyAccountTest extends BaseClass{
    @Test(groups = {"regression", "account"})
    public void TC_MA_001_verifyNavigationToMyAccountAfterLogin(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        Assert.assertTrue(accountPage.istxtMyAccountPresent(), "My Account is not present");
    }
}
