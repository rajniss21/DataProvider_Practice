package frontend.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
    public ShippingPage(WebDriver pWebdriver){
        PageFactory.initElements(pWebdriver, this);}


    /*
    * Shipping Page
    * */

    @FindBy(xpath = ".//*[@id='shipping_detail_form']")
    WebElement shippingAddressForm;

    @FindBy(xpath ="html/body/div[8]/div/div[2]")
    WebElement shippingInfoForm;

    @FindBy(xpath = "html/body/div[8]/div/div[2]/form[1]/div/div[1]/select")
    WebElement otherAddressSelect;

    @FindBy(xpath = "html/body/div[8]/div/div[2]/form[1]/div/div[5]/label/input")
    WebElement selectMyAddressRBtn;

    @FindBy(xpath = "html/body/div[8]/div/div[2]/form[1]/div/div[5]/select")
    WebElement myAddressSelect;

    @FindBy(xpath = "html/body/div[8]/div/div[2]/form[2]/div/div[7]/button")
    WebElement selectOffice_OtherAddressBtn;

    //@FindBy(xpath = ".//*[@id='addressSelectionForm']/div/div[4]/button")
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm new-address']")
    WebElement enterNewAddressBtn;

    @FindBy(xpath = ".//*[@id='addressSelectionForm']/div/button")
    WebElement shipppingNextBtn;

    //--------------------- Enter New Address Form ---------------------
    @FindBy()
    WebElement businessAddrInput;
    @FindBy(xpath = ".//*[@id='new_address']/div/div[2]/div/input")
    WebElement streetAddrInput;
    @FindBy()
    WebElement additionalStreetAddrInput;
    @FindBy(xpath = ".//*[@id='new_address']/div/div[4]/div/input")
    WebElement cityAddrInput;
    @FindBy(xpath = ".//*[@id='state']")
    WebElement stateSelection;
    @FindBy(xpath = ".//*[@id='new_address']/div/div[6]/div/input")
    WebElement zipcodeInput;

    @FindBy(xpath = "html/body/div[8]/div/div[2]/form[1]/div/div[1]/label/input")
    WebElement selectOtherAddressRBtn;

    @FindBy(xpath = ".//*[@id='new_address']/div/button")
    WebElement shippingSubmitBtn;
    //------------------------------------------------------------------------------------------------------------------


    public WebElement getShippingAddressForm(){return shippingAddressForm;}

    public WebElement getShippingInfoForm() {
        return shippingInfoForm;
    }

    public WebElement getBusinessAddrInput() {
        return businessAddrInput;
    }

    public WebElement getStreetAddrInput() {
        return streetAddrInput;
    }

    public WebElement getAdditionalStreetAddrInput() {
        return additionalStreetAddrInput;
    }

    public WebElement getCityAddrInput() {
        return cityAddrInput;
    }

    public WebElement getStateSelection() {
        return stateSelection;
    }

    public WebElement getZipcodeInput() {
        return zipcodeInput;
    }

    public WebElement getSubmitBtn() {
        return shippingSubmitBtn;
    }

    public WebElement getEnterNewAddressBtn() {
        return enterNewAddressBtn;
    }

    public WebElement getOtherAddressSelect() {
        return otherAddressSelect;
    }

    public WebElement getSelectMyAddressRBtn() {
        return selectMyAddressRBtn;
    }

    public WebElement getMyAddressSelect() {
        return myAddressSelect;
    }

    public WebElement getSelectOffice_OtherAddressBtn() {
        return selectOffice_OtherAddressBtn;
    }

    public WebElement getShipppingNextBtn() {
        return shipppingNextBtn;
    }

    public WebElement getSelectOtherAddressRBtn() {
        return selectOtherAddressRBtn;
    }

    public WebElement getShippingsubmitBtn() {
        return shippingSubmitBtn;
    }

}
