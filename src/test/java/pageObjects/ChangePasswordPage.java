package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage{
    @FindBy(xpath = "//h1[normalize-space()='Change Password']")
    WebElement txtChangePassword;

    public boolean istxtChangePasswordPresent(){
        try{
            waitForVisibility(txtChangePassword);
            return txtChangePassword.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
