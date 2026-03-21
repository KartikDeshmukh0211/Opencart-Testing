package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class BasePage {
    public WebDriver driver;

    BasePage(){
        this.driver = BaseClass.getDriver();
        PageFactory.initElements(driver, this);
    }
}


/*
    This base class will only contain the contstructor 
    as this constructor is common in every 
    page object class
*/
