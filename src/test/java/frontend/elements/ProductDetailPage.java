package frontend.elements;

import forDynamicElements.DynamicWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    WebDriver localWebDriver;

    public ProductDetailPage(WebDriver pWebdriver){
        PageFactory.initElements(pWebdriver, this);
        this.localWebDriver=pWebdriver;
    }

    public WebElement getMyColor(String colorName){
        DynamicWebElements myColorpicker = new DynamicWebElements(localWebDriver);
        return(myColorpicker.xpathorIDoftheDynamicElement("li[class^='product_color_buttons'][data-color-name='"+colorName+"']","css"));
    }

    public WebElement getMySize(String sizeID){
        DynamicWebElements mySizePicker = new DynamicWebElements(localWebDriver);
        return(mySizePicker.xpathorIDoftheDynamicElement(".//*[@data-size="+sizeID+"]","xpath"));
    }

    @FindBy(xpath=".//*[@id='cart_form']/div[3]/input") //.//*[@id='cart_form']/div[3]/input
            WebElement quantityInput;

    @FindBy(xpath = ".//*[@id='cart_form']/input[14]") //.//*[@id='cart_form']/input[14]
            WebElement addToCartBtn;

    @FindBy(xpath = ".//*[@id='toast-container']/div") // .//*[@id='toast-container']/div
            WebElement addedItemToCartToast;

    @FindBy(xpath = "html/body/div[4]/div/div[2]/div[1]/span")
    WebElement storeAdminTitleLabel;

    public WebElement getQuantityInput() {
        return quantityInput;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getAddedItemToCartToast() {
        return addedItemToCartToast;
    }

    public WebElement getStoreAdminTitleLabel() {
        return storeAdminTitleLabel;
    }
}
