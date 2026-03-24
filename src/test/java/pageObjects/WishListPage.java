package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement alertSuccess;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement lnkShoppingCart;

    @FindBy(xpath = "//p[normalize-space()='Your wish list is empty.']")
    WebElement txtWishListEmpty;

    public void clickAddToCart(){
        btnAddToCart.click();
    }

    public void clickLnkShoppingCart(){
        lnkShoppingCart.click();
    }

    public boolean isSuccess(){
        try{
            return alertSuccess.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean isWishListEmpty(){
        try{
            return txtWishListEmpty.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
