package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC_005_SearchTest extends BaseClass{
    @Test(groups = {"smoke", "regression", "search"})
    public void TC_SF_001_verifySearchWithValidProductName(){
        logger.info("***** TC_SF_001_verifySearchWithValidProductName started*****");

        HomePage homePage = new HomePage();
        String validProduct = "iMac";

        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();
        logger.info("Valid product entered and searched");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isLinkProductPresent(), "Product is not present");

        logger.info("***** TC_SF_001_verifySearchWithValidProductName ended*****\n");
    }

    // It is the negative test case..
    // we will enter worng data...
    @Test(groups = {"regression", "search"})
    public void TC_SF_002_verifySearchWithInvaildProductName(){
        logger.info("***** TC_SF_002_verifySearchWithInvaildProductName started*****");

        HomePage homePage = new HomePage();
        String invalidProduct = "Fitbit123";

        homePage.enterSearchInput(invalidProduct);
        homePage.clickSearch();
        logger.info("Invalid product entered and searched");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isNoproductAvailableDisplayed(), "Product is present");

        logger.info("***** TC_SF_002_verifySearchWithInvaildProductName ended*****\n");
    }

    @Test(groups = {"regression", "search"})
    public void TC_SF_003_verifySearchWithNoProdctName(){
        logger.info("***** TC_SF_003_verifySearchWithNoProdctName started*****");

        HomePage homePage = new HomePage();
        homePage.enterSearchInput("");
        homePage.clickSearch();

        logger.info("No product name entered and searched");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isNoproductAvailableDisplayed(), "product is present");

        logger.info("***** TC_SF_003_verifySearchWithNoProdctName ended*****\n");
    }

    @Test(groups = {"regression", "search"})
    public void TC_SF_004_verifySearchAfterLogin(){
        logger.info("***** TC_SF_004_verifySearchAfterLogin started*****");

        HomePage homePage = new HomePage();
        homePage.clickMyAccount();
        homePage.clickLogin();

        logger.info("Navigated to Login Page");
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(p.getProperty("email"));
        loginPage.enterPassword(p.getProperty("password"));
        loginPage.clickLogin();

        logger.info("Logged in successfully");

        String validProduct = "iMac";
        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();
        logger.info("Valid product entered and searched");

        logger.info("No product name entered and searched");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isLinkProductPresent(), "product is not present");

        logger.info("***** TC_SF_004_verifySearchAfterLogin ended*****\n");
    }

    @Test(groups = {"regression", "search"})
    public void TC_SF_005_verifySearchWithMultipleProducts(){
        logger.info("***** TC_SF_005_verifySearchWithMultipleProducts started*****");

        HomePage homePage = new HomePage();
        String validProduct = "Mac";

        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();
        logger.info("Product name entered and searched");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isMoreProductsPresent(), "More Products are not displayed");

        logger.info("***** TC_SF_005_verifySearchWithMultipleProducts ended*****\n");
    }
}
