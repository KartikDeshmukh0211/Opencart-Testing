package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public Logger logger;
    public Properties p;

    public static void setDriver(WebDriver driverInstance){
        tdriver.set(ThreadGuard.protect(driverInstance));
    }

    public static WebDriver getDriver(){
        return tdriver.get();
    }

    @BeforeClass(groups = {"smoke", "regression"})
    @Parameters({"os", "browser"})
    public void setup(@Optional("windows") String os, @Optional("chrome") String br) throws IOException{
        //Loading properties...
        FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LoggerFactory.getLogger(this.getClass());

        // WebDriver driverInstance = new ChromeDriver();
        WebDriver driverInstance;

        switch(br.toLowerCase()){
            case "chrome" : driverInstance = new ChromeDriver(); break;
            case "edge" : driverInstance = new EdgeDriver(); break;
            case "firefox" : driverInstance = new FirefoxDriver(); break;
            default : System.out.println("Invalid Browser"); return;
        }
        
        setDriver(driverInstance);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(p.getProperty("appURL"));
        getDriver().manage().window().maximize();
    }

    @AfterClass(groups = {"smoke", "regression"})
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        if(getDriver() != null){
            getDriver().quit();
        }
        tdriver.remove();
    }
}
