package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(){
        this.driver = BaseClass.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}


/*
    This base class will only contain the contstructor 
    as this constructor is common in every 
    page object class
*/
