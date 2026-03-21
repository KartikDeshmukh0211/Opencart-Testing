package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage {
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement txtAccountCreated;
    
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement btnContinue;

    public boolean istxtAccountCreatedPresent(){
        return txtAccountCreated.isDisplayed();
    }

    public void clickContinue(){
        btnContinue.click();
    }
}
