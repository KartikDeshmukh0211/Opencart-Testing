package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformationPage extends BasePage{
    @FindBy(xpath = "//h2[normalize-space()='Order History']")
    WebElement txtOrderHistory;

    public boolean istxtOrderHistoryPresent(){
        try{
            waitForVisibility(txtOrderHistory);
            return txtOrderHistory.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
