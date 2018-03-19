package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }

    @FindBy(id="email")
    WebElement emailInput;

    @FindBy(id="password")
    WebElement passwrdInput;

    @FindBy(id="login-btn")
    WebElement loginBtn;

    @FindBy(className="phpdebugbar-close-btn")
    WebElement phpDebuggerCloseBtn;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswrdInput() {
        return passwrdInput;
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }

    public WebElement getPhpDebuggerCloseBtn() {
        return phpDebuggerCloseBtn;
    }

}
