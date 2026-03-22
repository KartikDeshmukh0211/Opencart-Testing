package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement txtReturningCustomer;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    WebElement lnkForgottonPassword;
    
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement alertSuccess;

    public boolean isReturningCustomer(){
        return txtReturningCustomer.isDisplayed();
    }

    public void enterEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String psw){
        txtPassword.sendKeys(psw);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickForgottenPassword(){
        lnkForgottonPassword.click();
    }

    public boolean isSuccess(){
        return alertSuccess.isDisplayed();
    }
}
