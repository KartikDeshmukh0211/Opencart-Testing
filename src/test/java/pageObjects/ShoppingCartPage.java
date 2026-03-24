package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement txtShoppingCart;

    @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    WebElement btnContinueShopping;

    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement txtCartEmpty;

    public boolean istxtShoppingCartPresent(){
        try{
            waitForVisibility(txtShoppingCart);
            return txtShoppingCart.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void clickContinueShopping(){
        btnContinueShopping.click();
    }
    
    public boolean isCartEmpty(){
        try{
            return txtCartEmpty.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}