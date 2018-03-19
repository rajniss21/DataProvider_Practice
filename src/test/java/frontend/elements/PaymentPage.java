package frontend.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    public PaymentPage(WebDriver pWebdriver){
        PageFactory.initElements(pWebdriver, this);}


    /*
    * Payment Page
    * */
    //----------------------- Credit Card -----------------------

    @FindBy(xpath = ".//*[@id='payment_detail_form']")
    WebElement paymentDetailForm;

    @FindBy(xpath = "html/body/div[8]/div/div[2]/button[1]")
    WebElement creditCardOptionBtn;

    @FindBy(xpath = ".//*[@id='card-payment-form']/div[2]/div/input")
    WebElement nameOnCardInput;
    @FindBy(xpath = ".//*[@id='card-payment-form']/div[3]/div/input")
    WebElement creditCardNumberInput;
    @FindBy(xpath=".//*[@id='card-payment-form']/div[4]/div[1]/input")
    WebElement expirationMonthInput;
    @FindBy(xpath=".//*[@id='card-payment-form']/div[4]/div[2]/input")
    WebElement expirationYearInput;
    @FindBy(xpath=".//*[@id='card-payment-form']/div[5]/div/input")
    WebElement ccvInput;
    @FindBy(xpath=".//*[@id='card-payment-form']/div[6]/div/input")
    WebElement billZipCodeInput;

    //----------------------- Bill Me -----------------------

    @FindBy(xpath="html/body/div[8]/div/div[2]/button[2]")
    WebElement billMeOptionBtn;
    @FindBy(xpath = "")
    WebElement recipientInput;
    @FindBy()
    WebElement recipientEmailInput;
    @FindBy(xpath = ".//*[@id='bill-form']/button")
    WebElement billMeNextBtn;
    @FindBy(xpath=".//*[@id='card-payment-form']/button")
    WebElement cardPaymentNextBtn;

    public WebElement getPaymentDetailForm(){
        return paymentDetailForm;
    }

    public WebElement getCreditCardOptionBtn() {
        return creditCardOptionBtn;
    }

    public WebElement getNameOnCardInput() {
        return nameOnCardInput;
    }

    public WebElement getCreditCardNumberInput() {
        return creditCardNumberInput;
    }

    public WebElement getExpirationMonthInput() {
        return expirationMonthInput;
    }

    public WebElement getExpirationYearInput() {
        return expirationYearInput;
    }

    public WebElement getCcvInput() {
        return ccvInput;
    }

    public WebElement getBillZipCodeInput() {
        return billZipCodeInput;
    }

    public WebElement getBillMeOptionBtn() {
        return billMeOptionBtn;
    }

    public WebElement getRecipientInput() {
        return recipientInput;
    }

    public WebElement getRecipientEmailInput() {
        return recipientEmailInput;
    }

    public WebElement getBillMeNextBtn(){
        return billMeNextBtn;
    }

    public WebElement getCardPaymentNextBtn(){
        return cardPaymentNextBtn;
    }
}
