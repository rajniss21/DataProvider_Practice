package frontend.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }
    @FindBy(xpath = ".//*[@id='cart_detail']/div/a")
    WebElement placeOrderBtn;

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }
}
