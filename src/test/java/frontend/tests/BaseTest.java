package frontend.tests;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseTest {

    public WebDriver myWebDriver;
    public String MYURL;


   Logger myLogger_setup = Logger.getLogger("Setup");

    @BeforeMethod
    public void setup() throws IOException{
        PropertyConfigurator.configure("src/log4j.properties.");

        System.setProperty("webdriver.chrome.driver","./WebDrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        myWebDriver = new ChromeDriver(options);
        myLogger_setup.info("driver defined");

        readURL();
        myWebDriver.manage().window().maximize();
        myLogger_setup.info("Window maximized, now getting the URL.");
        myWebDriver.get(MYURL);
    }
    @AfterMethod
    public void teardown(){
        myLogger_setup.info("All test completed, quitting the driver.");
        myWebDriver.quit();
    }
    public void readURL() throws IOException{
        Properties propertiesObject =  new Properties();
        FileReader readMyPresets = new FileReader("product-description.properties");
        propertiesObject.load(readMyPresets);
        myLogger_setup.info("Reading the description file now.");

        MYURL= propertiesObject.getProperty("storeURL");
        readMyPresets.close();
    }
    public void waitfor(WebElement elementToWait, int timeOut){
        WebDriverWait waitforoption = new WebDriverWait(myWebDriver, timeOut);
        waitforoption.until(ExpectedConditions.visibilityOf(elementToWait));
    }
    public void waittoclick(WebElement elementToClick, int tiimeOut){
        WebDriverWait waitforoption = new WebDriverWait(myWebDriver, tiimeOut);
        waitforoption.until(ExpectedConditions.elementToBeClickable(elementToClick));
    }
    public void waittodissappear(WebElement elemToWait, int timeOut){
        WebDriverWait waitforoption = new WebDriverWait(myWebDriver, timeOut);
        waitforoption.until(ExpectedConditions.invisibilityOf(elemToWait));
    }
    public void assertContains(WebElement elementToAssert, String requiredText){
        Assert.assertTrue(elementToAssert.getText().contains(requiredText));
        myLogger_setup.info("Assertions results: \n"+"\tExpected Value: "+requiredText+"\n\t"+"Actual Value: "+elementToAssert.getText());
    }
    public void selectWebElement(WebElement webElementToSelect, String selectionValue){
        Select select = new Select(webElementToSelect);
        select.selectByValue(selectionValue);
    }
}
