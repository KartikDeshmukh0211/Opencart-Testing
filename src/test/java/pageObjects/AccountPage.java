package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txtMyAccount;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btnLogout;

    public boolean istxtMyAccountPresent(){
        return txtMyAccount.isDisplayed();
    }

    public void clickLogout(){
        btnLogout.click();
    }
}
