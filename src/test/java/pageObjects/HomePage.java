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

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
    WebElement btnLogout;

    @FindBy(xpath = "//div[@id='slideshow0']")
    WebElement imgHomePage;

    public void clickMyAccount(){
        btnMyAccount.click();
    }

    public void clickRegister(){
        btnRegister.click();
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        btnLogout.click();
    }

    public boolean isImgHomePagePresent(){
        return imgHomePage.isDisplayed();
    }
}
