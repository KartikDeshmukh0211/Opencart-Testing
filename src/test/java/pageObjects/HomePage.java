package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement alertSuccess;
    
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

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement txtInputSearch;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement btnSearch;

    @FindBy(xpath = "//a[normalize-space()='Qafox.com']")
    WebElement companyLogo;

    @FindBy(xpath = "//body/nav[@id='top']/div[@class='container']/div[@id='top-links']/ul[@class='list-inline']/li[3]")
    WebElement btnWishList;

    @FindBy(xpath = "//nav[@id='top']//li[5]")
    WebElement btnCheckout;

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

    public void enterSearchInput(String name){
        txtInputSearch.clear();  
        txtInputSearch.sendKeys(name);
    }

    public void clickSearch(){
        btnSearch.click();
    }

    public void clickCompanyLogo(){
        // by clicking on the logo, we can navigate back to the home page
        waitForClickability(companyLogo); 
        companyLogo.click();
    }

    public void clickWishList(){
        btnWishList.click();
    }

    public boolean isSuccess(){
        try{
            return alertSuccess.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void clickCheckout(){
        btnCheckout.click();
    }
}
