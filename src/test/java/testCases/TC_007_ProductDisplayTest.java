package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC_007_ProductDisplayTest extends BaseClass{
    @Test
    public void TC_PDP_001_verifyProductThumbnails() throws InterruptedException{
        HomePage homePage = new HomePage();
        String validProduct = "iMac";
        homePage.enterSearchInput(validProduct);
        homePage.clickSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickProductImac();

        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.clickProductThumbnail();

        // Thread.sleep(3000);

        Assert.assertTrue(productDisplayPage.isImgHolderConatinerPresent(), "Image is not present");

        productDisplayPage.clickRightArrow();
        productDisplayPage.clickRightArrow();
        Assert.assertTrue(productDisplayPage.isImgHolderConatinerPresent(), "Image is not present");

        productDisplayPage.clickLeftArrow();
        productDisplayPage.clickLeftArrow();
        Assert.assertTrue(productDisplayPage.isImgHolderConatinerPresent(), "Image is not present");
        
        productDisplayPage.clickCross();
        Assert.assertTrue(productDisplayPage.isProductThumbnailDisplayed(), "Image is not present");

        List<WebElement> additionalImages = productDisplayPage.getAdditionalImages();

        for (WebElement img : additionalImages) {
            img.click();
            Assert.assertTrue(productDisplayPage.isImgHolderConatinerPresent(), "Image is not present");
            productDisplayPage.clickCross();
        }        
    }
}