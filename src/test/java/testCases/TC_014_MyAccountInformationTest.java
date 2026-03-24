package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInformationPage;
import testBase.BaseClass;

public class TC_014_MyAccountInformationTest extends BaseClass{
    @Test
    public void TC_MAI_001_verifyMyAccountInfoNavigatonFromMyAcc(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        accountPage.clickLnkEditMyAccount();

        MyAccountInformationPage myAccountInformationPage = new MyAccountInformationPage();
        Assert.assertTrue(myAccountInformationPage.istxtMyAccountInfoPresnt(), "My Account Page is not Visible");
    }
}
