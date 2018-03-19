package frontend.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    public ContactPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }

    //Contact Page.............
    @FindBy(xpath = "html/body/div[8]/div/div[2]/form/button")
    WebElement contactNextBtn;

    // end................

    //Signned In Case.....
    @FindBy(xpath = ".//*[@id='contact_detail_form']/form/div[3]/div/input")
    WebElement sPhoneNumberInput;

    public WebElement getContactNextBtn() {
        return contactNextBtn;
    }

    public WebElement getsPhoneNumberInput() {
        return sPhoneNumberInput;
    }
}
