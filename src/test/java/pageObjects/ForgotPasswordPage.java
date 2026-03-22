package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
    @FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
    WebElement txtForgotPassword;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;
    
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    public boolean istxtForgotPasswordPresent(){
        return txtForgotPassword.isDisplayed();
    }
    
    public void enterEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void clickContinue(){
        btnContinue.click();
    }
}
