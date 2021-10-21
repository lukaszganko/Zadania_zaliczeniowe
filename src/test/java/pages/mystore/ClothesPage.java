package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClothesPage {
    public WebDriver driver;


    @FindBy(xpath = "//img[@alt='Brown bear printed sweater']")
    public WebElement brownBearSweater;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    public WebElement quantityInput;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    public WebElement addToCartButton;


    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//section[@id='checkout-delivery-step']")
    public WebElement shippingMethodSection;


    @FindBy(xpath = "//input[@id='delivery_option_1']")
    public WebElement prestaShopRadioButton;

    @FindBy(xpath = "//section[@id='checkout-payment-step']")
    public WebElement paymentSection;

    @FindBy(xpath = "//label[@for='payment-option-1']")
    public WebElement payByCheckRadioButton;

    @FindBy(xpath = "//label[@for='conditions_to_approve[terms-and-conditions]']")
    public WebElement agreeToTheTermsCheckbox;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    public WebElement orderWithAnObligationToPayButton;





    public ClothesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void addClothes(String size, String quantity) {
        brownBearSweater.click();
        Select sizeDropDown = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        sizeDropDown.selectByVisibleText(size);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        addToCartButton.click();
        proceedToCheckout.click();
        proceedToCheckout.click();
        shippingMethodSection.click();
//        prestaShopRadioButton.click();
        paymentSection.click();
        payByCheckRadioButton.click();
        agreeToTheTermsCheckbox.click();
        orderWithAnObligationToPayButton.click();


    }

}
