package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public Properties p;

    public static void setDriver(WebDriver driverInstance){
        tdriver.set(ThreadGuard.protect(driverInstance));
    }

    public static WebDriver getDriver(){
        return tdriver.get();
    }

    @BeforeClass
    public void setup() throws IOException{
        //Loading properties...
        FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        WebDriver driverInstance = new ChromeDriver();
        setDriver(driverInstance);

        getDriver().get(p.getProperty("appURL"));
        getDriver().manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        if(getDriver() != null){
            getDriver().quit();
        }
        tdriver.remove();
    }

    public String randomString(){
        return RandomStringUtils.secure().nextAlphabetic(6);
    }

    public String randomNumber(){
        return RandomStringUtils.secure().nextNumeric(10);
    }

    public String randomAplhaNumric(){
        return RandomStringUtils.secure().nextAlphanumeric(8);
    }
}
