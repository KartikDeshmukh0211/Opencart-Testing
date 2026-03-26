package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.AddressBookEntryPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_016_AddressBookTest extends BaseClass{
    @Test(groups = {"regression", "account"})
    public void TC_AB_001_verifyAddBookPageNavFromAccPage(){
        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        AccountPage accountPage = new AccountPage();
        accountPage.clickLnkModifyYourAddressBook();

        AddressBookEntryPage addressBookEntryPage = new AddressBookEntryPage();
        Assert.assertTrue(addressBookEntryPage.istxtAddressBookEntryPresent(), "Address Book Entry Page is not Visible");
    }
}
