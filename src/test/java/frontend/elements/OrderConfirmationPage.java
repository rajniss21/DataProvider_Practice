package frontend.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    public OrderConfirmationPage(WebDriver pWebdriver){
        PageFactory.initElements(pWebdriver, this);
    }





    /*
    * Confirmation Page
    * */

    @FindBy(xpath = "..//*[@id='order-form']/div[3]/div/table/tbody/tr[1]/td[5]/h2]")
    WebElement subTotal;

    @FindBy(xpath = ".//*[@id='order-form']/div[3]/div/table/tbody/tr[3]/td[4]/label")
    WebElement shippingCharge;

    @FindBy(xpath = ".//*[@id='order-form']/div[3]/div/table/tbody/tr[2]/td[4]/label")
    WebElement salesTax;

    @FindBy(xpath = ".//*[@id='order-form']/div[3]/div/table/tbody/tr[4]/td[5]/h2")
    WebElement totalPrice;

    @FindBy(xpath = ".//*[@id='confirm-order']")
    WebElement orderBtn;

    @FindBy(xpath = ".//*[@id='cart_detail']/div/div/h4")
    WebElement orderPlacedMessage;

    public WebElement getSubTotal() {
        return subTotal;
    }

    public WebElement getShippingCharge() {
        return shippingCharge;
    }

    public WebElement getSalesTax() {
        return salesTax;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getOrderBtn() {
        return orderBtn;
    }

    public WebElement getOrderPlacedMessage(){
        return  orderPlacedMessage;
    }
}
