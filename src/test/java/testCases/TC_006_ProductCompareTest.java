package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC_006_ProductCompareTest extends BaseClass{
    @Test
    public void TC_PC_001_verifyCompareFromProductDisplayPage(){
        logger.info("***** TC_006_ProductCompareTest started*****");

        HomePage homePage = new HomePage();
        String validProduct = "iMac";

        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();
        logger.info("Valid product entered and searched");

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickProductImac();

        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        String actualTooltip = "Compare this Product";
        Assert.assertEquals(productDisplayPage.getTootipOfProductCompare(), actualTooltip);

        productDisplayPage.clickProductCompare();
        Assert.assertTrue(productDisplayPage.isSuccessMessagePresent(), "Product doesn't get added");

        productDisplayPage.clickLnkProductCompare();

        ProductComparePage productComparePage = new ProductComparePage();
        Assert.assertTrue(productComparePage.istxtProductComparePresent(), "Product Compare is not Present");

        logger.info("***** TC_006_ProductCompareTest ended*****\n");
    }
}
