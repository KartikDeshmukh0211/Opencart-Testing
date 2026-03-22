package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogoutPage extends BasePage{
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement txtAccountLogout;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnContinue;

    public boolean istxtAccountLogoutPresent(){
        return txtAccountLogout.isDisplayed();
    }

    public void clickContinue(){
        btnContinue.click();
    }
}
