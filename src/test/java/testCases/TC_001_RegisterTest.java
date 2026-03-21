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
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage();
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

        AccountSuccessPage accountSuccessPage = new AccountSuccessPage();
        Assert.assertTrue(accountSuccessPage.istxtAccountCreatedPresent(), "Your Account Has not Been Created!");
        accountSuccessPage.clickContinue();

        AccountPage accountPage = new AccountPage();
        Assert.assertTrue(accountPage.istxtMyAccountPresent(), "My Account is not present");        
    }
}

