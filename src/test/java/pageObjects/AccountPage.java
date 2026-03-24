package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txtMyAccount;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btnLogout;

    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    WebElement lnkEditMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Change your password']")
    WebElement lnkChangePassword;

    @FindBy(xpath = "//a[normalize-space()='Modify your address book entries']")
    WebElement lnkModifyYourAddressBook;

    @FindBy(xpath = "//a[normalize-space()='View your order history']")
    WebElement lnkViewYourOrderHistory;

    public boolean istxtMyAccountPresent(){
        return txtMyAccount.isDisplayed();
    }

    public void clickLogout(){
        btnLogout.click();
    }

    public void clickLnkEditMyAccount(){
        lnkEditMyAccount.click();
    }

    public void clickLnkChangePassword(){
        lnkChangePassword.click();
    }

    public void clickLnkModifyYourAddressBook(){
        lnkModifyYourAddressBook.click();
    }

    public void clickViewYourOrderHistory(){
        lnkViewYourOrderHistory.click();
    }
}
