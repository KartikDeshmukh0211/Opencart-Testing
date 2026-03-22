package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_RegisterTest extends BaseClass{
    @Test
    public void TC_RF_001_verifyRegistrationWithMandatoryFields(){
        logger.info("***** TC_RF_001_verifyRegistrationWithMandatoryFields started *****");
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        logger.info("My Account button got clicked....");

        homePage.clickRegister();
        logger.info("Register button get clicked");

        RegisterPage registerPage = new RegisterPage();
        logger.info("Entering details.....");
        registerPage.enterFirstName(randomString());
        registerPage.enterLastName(randomString());
        registerPage.enterEmail(randomAplhaNumric() + "@gmail.com");
        registerPage.enterTelephone(randomNumber());

        String password = randomAplhaNumric();
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);

        registerPage.selectNewsletter("Yes");
        registerPage.selectChkBox();
        registerPage.clickContinue();
        logger.info("Continue button clicked");

        logger.info("Account Success Page appeared...");
        AccountSuccessPage accountSuccessPage = new AccountSuccessPage();
        Assert.assertTrue(accountSuccessPage.istxtAccountCreatedPresent(), "Your Account Has not Been Created!");
        accountSuccessPage.clickContinue();
        logger.info("Continue button clicked");

        logger.info("Home page appeated.....");
        AccountPage accountPage = new AccountPage();
        Assert.assertTrue(accountPage.istxtMyAccountPresent(), "My Account is not present");       
        
        logger.info("***** TC_RF_001_verifyRegistrationWithMandatoryFields ended *****\n");
    }
}

