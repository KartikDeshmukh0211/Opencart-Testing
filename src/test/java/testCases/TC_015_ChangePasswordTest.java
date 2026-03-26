package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_015_ChangePasswordTest extends BaseClass{
    @Test(groups = {"regression", "account"})
    public void TC_CP_001_verifyChangePasswordPageNavFromMyAcc(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        accountPage.clickLnkChangePassword();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        Assert.assertTrue(changePasswordPage.istxtChangePasswordPresent(), "Change Password Page is not Visible");
    }
}
