package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookEntryPage extends BasePage{
    @FindBy(xpath = "//h2[normalize-space()='Address Book Entries']")
    WebElement txtAddressBookEntry;

    public boolean istxtAddressBookEntryPresent(){
        try{
            waitForVisibility(txtAddressBookEntry);
            return txtAddressBookEntry.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
