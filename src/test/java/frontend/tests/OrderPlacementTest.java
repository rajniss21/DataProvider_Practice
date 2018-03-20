package frontend.tests;

import frontend.elements.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class OrderPlacementTest extends BaseTest{

    private String productCode;
    private String colorname;
    private String productSize;
    private String quantity;
    private String creditCardOwner;
    private String creditCardNumber;

    @Test
    public void orderPlacementFromFrontEnd() throws IOException, InterruptedException{

        readOrderValues();

        LandingPage landingPageObj = new LandingPage(myWebDriver);
        CartPage cartPageObj = new CartPage(myWebDriver);
        ContactPage contactPageObj = new ContactPage(myWebDriver);
        OrderConfirmationPage orderConfirmationPageObj = new OrderConfirmationPage(myWebDriver);
        PaymentPage paymentPageObj = new PaymentPage(myWebDriver);
        ProductDetailPage productDetailPageObj = new ProductDetailPage(myWebDriver);
        ShippingPage shippingPageObj = new ShippingPage(myWebDriver);

        landingPageObj.getSearchInput().sendKeys(productCode, Keys.ENTER);
        productDetailPageObj.getMyColor(colorname).click();
        productDetailPageObj.getMySize(productSize).click();
        productDetailPageObj.getQuantityInput().clear();
        productDetailPageObj.getQuantityInput().sendKeys(quantity);
        productDetailPageObj.getAddToCartBtn().click();
        waitfor(productDetailPageObj.getAddedItemToCartToast(), 10);
        assertContains(productDetailPageObj.getAddedItemToCartToast(), "Item added to cart Successfully");

        readURL();
        myWebDriver.get(MYURL+"cart");

        landingPageObj.getSignin_outButton().click();
        waitfor(landingPageObj.getSignInForm(), 10);
        landingPageObj.getSigninEmailInput().sendKeys("ekgothamuser@gmail.com");
        landingPageObj.getSigninPasswordInput().sendKeys("ironmansucks");
        landingPageObj.getSignInSubmitBtn().click();

        Thread.sleep(2500);
        cartPageObj.getPlaceOrderBtn().click();
        Thread.sleep(2500);

        contactPageObj.getContactNextBtn().click();

        waitfor(shippingPageObj.getShippingAddressForm(), 10);
        shippingPageObj.getEnterNewAddressBtn().click();
        shippingPageObj.getStreetAddrInput().sendKeys("120 Bush St");
        shippingPageObj.getCityAddrInput().sendKeys("San Francisco");
        shippingPageObj.getZipcodeInput().sendKeys("94104-41317");
        selectWebElement(shippingPageObj.getStateSelection(), "CA");
        shippingPageObj.getShippingsubmitBtn().click();

        waitfor(paymentPageObj.getPaymentDetailForm(), 10);
        paymentPageObj.getCreditCardOptionBtn().click();
        paymentPageObj.getNameOnCardInput().sendKeys(creditCardOwner);
        paymentPageObj.getExpirationMonthInput().sendKeys("05");
        paymentPageObj.getExpirationYearInput().sendKeys("2020");
        paymentPageObj.getCcvInput().sendKeys("123");
        paymentPageObj.getCreditCardNumberInput().sendKeys(creditCardNumber);
        paymentPageObj.getCardPaymentNextBtn().click();

        waitfor(orderConfirmationPageObj.getOrderBtn(), 10);
        orderConfirmationPageObj.getOrderBtn().click();
        waitfor(landingPageObj.getToastMessage(), 10);
        assertContains(landingPageObj.getToastMessage(), "Your order is successfully placed");

    }

    public void readOrderValues() throws IOException{
        Properties propertiesObject = new Properties();
        FileReader readMyPresets = new FileReader("product-description.properties");

        propertiesObject.load(readMyPresets);

        productCode=propertiesObject.getProperty("product-id");
        colorname=propertiesObject.getProperty("color");
        productSize=propertiesObject.getProperty("size");
        quantity=propertiesObject.getProperty("quantity");
        creditCardOwner=propertiesObject.getProperty("creditcard-owner");
        creditCardNumber=propertiesObject.getProperty("creditcard-number");

        readMyPresets.close();



    }
}
