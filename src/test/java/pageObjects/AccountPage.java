package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txtMyAccount;

    public boolean istxtMyAccountPresent(){
        return txtMyAccount.isDisplayed();
    }
}
