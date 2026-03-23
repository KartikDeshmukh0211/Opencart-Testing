package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage{
    @FindBy(xpath = "//h1[normalize-space()='Product Comparison']")
    WebElement txtProductCompare;

    public boolean istxtProductComparePresent(){
        return txtProductCompare.isDisplayed();
    }
}
