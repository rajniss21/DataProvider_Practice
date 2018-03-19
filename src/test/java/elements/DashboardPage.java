package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);}

        @FindBy(id = "logged-in-user")
        WebElement nameOfTheUserLoggedIn;

        @FindBy(id="loader-gif")
        WebElement processLoader;

        @FindBy(id ="flash-message")
        WebElement flashMessage;

    public WebElement getNameOfTheUserLoggedIn() {
        return nameOfTheUserLoggedIn;
    }

    public WebElement getProcessLoader() {
        return processLoader;
    }

    public WebElement getFlashMessage() {
        return flashMessage;
    }



}
