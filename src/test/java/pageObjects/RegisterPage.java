package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(className = "radio-inline")
    List<WebElement> newsletterOptions;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkAgree;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    public void enterFirstName(String fname){
        txtFirstName.sendKeys(fname);
    }

    public void enterLastName(String lname){
        txtLastName.sendKeys(lname);
    }

    public void enterEmail(String emial){
        txtEmail.sendKeys(emial);
    }

    public void enterTelephone(String num){
        txtTelephone.sendKeys(num);
    }

    public void enterPassword(String psw){
        txtPassword.sendKeys(psw);
    }

    public void enterConfirmPassword(String psw){
        txtConfirmPassword.sendKeys(psw);
    }

    public void selectNewsletter(String option){
        if(option.equalsIgnoreCase("yes")){
            newsletterOptions.get(0).click();
        }else{
            newsletterOptions.get(1).click();
        }
    }

    public void selectChkBox(){
        chkAgree.click();
    }

    public void clickContinue(){
        btnContinue.click();
    }
}
