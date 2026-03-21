package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement btnMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement btnRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement btnLogin;

    public void clickMyAccount(){
        btnMyAccount.click();
    }

    public void clickRegister(){
        btnRegister.click();
    }

    public void clickLogin(){
        btnLogin.click();
    }
}
