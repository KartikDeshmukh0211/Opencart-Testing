package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//div[@class='product-thumb']")
    WebElement linkProductName; // here it will be imac

    @FindBy(xpath = "//div[@class='image']//a")
    WebElement linkProductImac;

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    WebElement txtNoProductAvailable;

    @FindBy(className = "product-thumb")
    List<WebElement> linkAllProducts;

    public boolean isLinkProductPresent(){
        return linkProductName.isDisplayed();
    }

    public boolean isNoproductAvailableDisplayed(){
        return txtNoProductAvailable.isDisplayed();
    }

    public boolean isMoreProductsPresent(){
        // will return true if more than 1 product is present
        return linkAllProducts.size() > 1;
    }

    public void clickProductImac(){
        linkProductImac.click();
    }
}
