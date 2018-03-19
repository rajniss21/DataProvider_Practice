package forDynamicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicWebElements {


    public WebDriver classWebdriver;

    public WebElement webElementToprocess;

    public DynamicWebElements(WebDriver paramDriver){
        this.classWebdriver=paramDriver;
    }

    public void assignDynamicValues(String xpathOrid) {
        By myElementLocator = By.id(xpathOrid);
        this.webElementToprocess= classWebdriver.findElement(myElementLocator);
    }
    public WebElement xpathorIDoftheDynamicElement(String elementxpathorid, String type){
        if(type=="xpath"){
            By myElementLocator = By.xpath(elementxpathorid);
            this.webElementToprocess= classWebdriver.findElement(myElementLocator);
        }
        if(type=="id"){
            By myElementLocator = By.id(elementxpathorid);
            this.webElementToprocess= classWebdriver.findElement(myElementLocator);
        }
        if(type=="css"){
            By myElementLocator = By.cssSelector(elementxpathorid);
            this.webElementToprocess= classWebdriver.findElement(myElementLocator);
        }
        return webElementToprocess;
    }
    public void xpathForTheAdditionalLogoTest(String elementXpath,String Names){

        By myElementLocator = By.xpath(elementXpath);
        this.webElementToprocess= classWebdriver.findElement(myElementLocator);
        webElementToprocess.sendKeys(Names);
        webElementToprocess.sendKeys(Keys.ENTER);
    }



}
