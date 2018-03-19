package frontend.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public LandingPage(WebDriver pWebdriver){
        PageFactory.initElements(pWebdriver, this);
    }

    @FindBy(xpath = "html/body/div[4]/div/div[2]/div[1]/button[1]") //
            WebElement signin_outButton;
    @FindBy(xpath = "html/body/div[4]/div/div[2]/div[1]/button[3]")
    WebElement cartButton;
    @FindBy(xpath = ".//*[@id='searchValue']") //click first
            WebElement searchInput;
    @FindBy(xpath = ".//*[@id='mainmenu']")
    WebElement menuButton;

    @FindBy(xpath = "html/body/div[7]/div/div[2]/div[1]")
    WebElement toastMessage;

    @FindBy(xpath = "//html/body/div[12]")   //here 12 keeps changing, have to assign id to this
            WebElement cartSlider;

    @FindBy(xpath = "html/body/div[7]/div/div[1]/div[2]/a")
    WebElement viewOrderHistoryLink;

    @FindBy(xpath = "html/body/div[4]/div/div[2]/div[1]/span")
    WebElement storeAdminLabel;

    @FindBy(xpath = "//html/body/div[12]/div[3]/a")   //here 12 keeps changing had to assign something
            WebElement proceedToCheckoutButton;
    @FindBy(xpath = ".//*[@id='cart_detail']/div/a")
    WebElement proceedFurther;

    //------------------- Sign In Model ----------------------

    @FindBy(xpath = ".//*[@id='signIn']/div[2]/div")
    WebElement signinModel;
    //signInForm
    @FindBy(xpath = "//form[@class='signInForm']")
    WebElement signInForm;
    @FindBy(xpath = ".//*[@id='exampleInputEmail1']")
    WebElement signinEmailInput;
    @FindBy(xpath = ".//*[@id='exampleInputPassword1']")
    WebElement signinPasswordInput;
    @FindBy(xpath = ".//*[@id='signIn']/div[2]/div/div[2]/form/div[4]/button")
    WebElement signInSubmitBtn;

    //------------------- End ------------------

    public WebElement getSignin_outButton() {
        return signin_outButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getToastMessage(){
        return  toastMessage;
    }

    public WebElement getCartSlider() {
        return cartSlider;
    }

    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public WebElement getProceedFurther() {
        return proceedFurther;
    }

    public WebElement getSigninEmailInput() {
        return signinEmailInput;
    }

    public WebElement getSigninPasswordInput() {
        return signinPasswordInput;
    }

    public WebElement getSignInSubmitBtn() {
        return signInSubmitBtn;
    }

    public WebElement getSigninModel(){
        return signinModel;
    }

    public WebElement getSignInForm(){
        return signInForm;
    }
}
