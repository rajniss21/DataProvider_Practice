package test;

import elements.DashboardPage;
import elements.LoginPage;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

public class OverallSetup {

    public WebDriver myWebDriver;
    public String MYURL = "http://admin.qa.yurstore.net";
    Logger myLogger_setup = Logger.getLogger("Setup");

    @BeforeMethod
    public void setup(){
        PropertyConfigurator.configure("src/log4j.properties");
        System.setProperty("webdriver.chrome.driver","./WebDrivers/chromedriver");
        myWebDriver = new ChromeDriver();
        myLogger_setup.info("Driver Defined");
        myWebDriver.manage().window().maximize();
        myLogger_setup.info("Window maximized, now getting the URL");
        myWebDriver.get(MYURL);
        myLogger_setup.info("Login page opened successfully");
    }
    @AfterMethod
    public void teardown(){
        myLogger_setup.info("All test completed, quitting the driver");
        myWebDriver.quit();
    }
    public void checkedIfLoggedIn(){
        DashboardPage dashboardPageObj = new DashboardPage(myWebDriver);
        Assert.assertEquals(dashboardPageObj.getNameOfTheUserLoggedIn().getText(), "Yurstore Superadmin");
        myLogger_setup.info("Login Successful");
    }
   /* public void LoginToTheModule(){
        LoginPage loginPageObj = new LoginPage(myWebDriver);
        loginPageObj.setEmailInput("superadmin@yurstore.com");
        loginPageObj.setPasswordInput("123admin@");
        loginPageObj.clickLoginBtn();
    }*/
    public void waitFor(WebElement elementToWait){
        WebDriverWait waitForOption = new WebDriverWait(myWebDriver, 8);
        waitForOption.until(ExpectedConditions.visibilityOf(elementToWait));
    }
    public void assertContains(WebElement elementToAssert, String requiredText){
        Assert.assertTrue(elementToAssert.getText().contains(requiredText));
        myLogger_setup.info("Assertions Results: \n"+"\tExpected value: "+requiredText+"n\t"+"Actual value: "+elementToAssert.getText());
    }
    public void selectWebElement(WebElement webElementToSelect, String selectionValue){
        Select select = new Select(webElementToSelect);
        select.selectByVisibleText(selectionValue);
    }


}
