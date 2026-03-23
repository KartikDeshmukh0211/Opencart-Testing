package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ProductDisplayPage  extends BasePage{
    @FindBy(xpath = "//div[@class='col-sm-4']//button[2]")
    WebElement btnProductCompare;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement txtSuccess;

    @FindBy(xpath = "//a[normalize-space()='product comparison']")
    WebElement lnkProductCompare;

    @FindBy(xpath = "//ul[@class='thumbnails']//li[1]//a[1]")
    WebElement imgProductThumbnail;

    @FindBy(className = "mfp-img")
    WebElement imgHolderContainer;

    @FindBy(xpath = "//button[@title='Next (Right arrow key)']")
    WebElement arrowRight;

    @FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
    WebElement arrowLeft;

    @FindBy(xpath = "//button[normalize-space()='×']")
    WebElement btnCross;

    @FindBy(className = "image-additional")
    List<WebElement> imgAdditionals;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement lnkShopingCart;

    @FindBy(xpath = "//div[@id='product-product']//div[@class='btn-group']//button[1]")
    WebElement btnAddToWishList;

    public String getTootipOfProductCompare(){
        return btnProductCompare.getAttribute("data-original-title");
    }

    public void clickProductCompare(){
        btnProductCompare.click();
    }

    public boolean isSuccessMessagePresent(){
        return txtSuccess.isDisplayed();
    }

    public void clickLnkProductCompare(){
        lnkProductCompare.click();
    }

    public void clickProductThumbnail(){
        imgProductThumbnail.click();
    }

    public boolean isProductThumbnailDisplayed(){
        try{
            waitForVisibility(imgProductThumbnail);
            return imgProductThumbnail.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean isImgHolderConatinerPresent(){
        try {
            waitForVisibility(imgHolderContainer);
            return imgHolderContainer.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void clickRightArrow(){
        arrowRight.click();
    }

    public void clickLeftArrow(){
        arrowLeft.click();
    }

    public void clickCross(){
        btnCross.click();
    }

    public List<WebElement> getAdditionalImages(){
        return imgAdditionals;
    }

    public void clickAddToCart(){
        btnAddToCart.click();
    }

    public void clickLnkShoppingCart(){
        lnkShopingCart.click();
    }

    public void clickAddToWishList(){
        btnAddToWishList.click();
    }
}
