package test;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Setup {

    public WebDriver myWebDriver;

    public String MYURL;
    public String loginEmail;
    public String loginPassword;
    public String driver_selection;
    public Properties propertiesObject = new Properties();

    Logger myLogger_setup = Logger.getLogger("Setup");

    @BeforeSuite
    public void baseSetup() throws IOException{
        PropertyConfigurator.configure("src/log4j.properties");
        myLogger_setup.info("Running the base setup, laying the ground work properly");
        checkOS();

    }
    public void checkOS() throws IOException{
        FileWriter setupPropertiesFile = new FileWriter("src/driver-select.properties");

        String OperatingSystem = System.getProperty("os.name");

        myLogger_setup.info("Running test on"+OperatingSystem+" system. Now setting the correct driver.");
        if (OperatingSystem.contains("Linux")){
            propertiesObject.setProperty("driver_status","chromedriver");
        }
        else{
            propertiesObject.setProperty("driver_status","chromedriver.exe");
        }
        propertiesObject.store(setupPropertiesFile, null);
        setupPropertiesFile.close();
    }
    public void readConstantsValues() throws IOException{
        FileReader readMyConfig = new FileReader("src/config.properties");

        propertiesObject.load(readMyConfig);
        myLogger_setup.info("Reading the config file now...");
        MYURL=propertiesObject.getProperty("Main_URL");
        loginEmail=propertiesObject.getProperty("login_email");
        loginPassword=propertiesObject.getProperty("login_password");

        readMyConfig.close();

        FileReader readDriverSelect = new FileReader("src/driver-select.properties");
        propertiesObject.load(readDriverSelect);
        driver_selection=propertiesObject.getProperty("driver_status");
        readDriverSelect.close();
    }
    @BeforeMethod
    public void setup() throws IOException{
        readConstantsValues();

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "./WebDrivers/"+driver_selection);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobabrs");
        myWebDriver= new ChromeDriver(options);
        myLogger_setup.info("Driver Defined");
        myWebDriver.manage().window().maximize();
        myLogger_setup.info("Window maximized, now getting the URL");
        myWebDriver.get("http://"+MYURL);
        myLogger_setup.info("Login page opened successfully");
    }
    @AfterMethod
    public void teardown(){
        myLogger_setup.info("All test completed, now quiting the driver...");
        myWebDriver.quit();
    }
}
