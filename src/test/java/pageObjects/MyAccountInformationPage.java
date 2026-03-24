package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountInformationPage extends BasePage{
    @FindBy(xpath = "//h1[normalize-space()='My Account Information']")
    WebElement txtMyAccountInformation;

    public boolean istxtMyAccountInfoPresnt(){
        try{
            waitForVisibility(txtMyAccountInformation);
            return txtMyAccountInformation.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
