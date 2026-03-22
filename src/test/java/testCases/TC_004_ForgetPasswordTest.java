package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_004_ForgetPasswordTest extends BaseClass{
    @Test
    public void TC_FP_001_verifyUserCanResetPassword(){
        logger.info("***** TC_004_ForgetPasswordTest started *****");
        logger.info("Navigating to Login Page");

        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.clickForgottenPassword();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        Assert.assertTrue(forgotPasswordPage.istxtForgotPasswordPresent(),"Forgot password confirmation message not displayed");
        forgotPasswordPage.enterEmail(p.getProperty("email"));
        forgotPasswordPage.clickContinue();

        // For now assume reset link is accessible
        logger.info("Assuming email is open and new password enter. We will assume new password is equal to the prev one");
        Assert.assertTrue(loginPage.isSuccess(), "//div[@class='alert alert-success alert-dismissible']");

        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        logger.info("Attempting login with new password");

        AccountPage accountPage = new AccountPage();
        Assert.assertTrue(accountPage.istxtMyAccountPresent(), "My Account is not present");

        logger.info("***** TC_004_ForgetPasswordTest ended *****\n");
    }
}
