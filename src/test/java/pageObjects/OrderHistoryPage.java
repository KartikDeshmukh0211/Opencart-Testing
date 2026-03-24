package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage{
    @FindBy(xpath = "//h1[normalize-space()='Order History']")
    WebElement txtOrderHistory;

    public boolean istxtOrderHistoryPresnt(){
        try{
            waitForVisibility(txtOrderHistory);
            return txtOrderHistory.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
