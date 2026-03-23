package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement txtShoppingCart;

    public boolean istxtShoppingCartPresent(){
        try{
            waitForVisibility(txtShoppingCart);
            return txtShoppingCart.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
    
}