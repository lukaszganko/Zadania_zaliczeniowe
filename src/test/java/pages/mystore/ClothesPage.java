package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClothesPage {
    public WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, 15);


    @FindBy(xpath = "//img[@alt='Brown bear printed sweater']")
    public WebElement brownBearSweater;

    @FindBy(xpath = "(//span[@class='regular-price'])[2]")
    public WebElement brownBearSweaterRegularPrice;

    @FindBy(xpath = "(//span[@class='price'])[2]")
    public WebElement brownBearSweaterDiscountPrice;

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

    @FindBy(xpath = "//div[@id='order-details']")
    public WebElement orderDetails;

    @FindBy(xpath = "//div[@class='cart-summary-line cart-total']//span[@class='value']")
    public WebElement totalValue;


    public ClothesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void addClothes(String size, String quantity) {
        String regularPriceBrownSweater = brownBearSweaterRegularPrice.getText().replaceAll("€", "");
        Double regularPriceBrownSweater2 = Double.valueOf(regularPriceBrownSweater);

        System.out.println(regularPriceBrownSweater2);

        double rabat = regularPriceBrownSweater2 * 20/100;
        double obliczonyRabat = regularPriceBrownSweater2 - rabat;

        System.out.println(obliczonyRabat);

        String brownBearSweaterDiscountPricebezEuro = brownBearSweaterDiscountPrice.getText().replaceAll("€", "");
        Double brownBearSweaterDiscountPricebezEuro2 = Double.valueOf(brownBearSweaterDiscountPricebezEuro);
        if (obliczonyRabat==brownBearSweaterDiscountPricebezEuro2){
            System.out.println("Rabat wyliczony jest prawidłowo");
        }

        brownBearSweater.click();
        Select sizeDropDown = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        sizeDropDown.selectByVisibleText(size);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        addToCartButton.click();
        //dodać potencjalnego waita
//        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();
        proceedToCheckout.click();
        shippingMethodSection.click();
        if (!prestaShopRadioButton.isSelected()) {
            prestaShopRadioButton.click();
        }
        paymentSection.click();
        payByCheckRadioButton.click();
        agreeToTheTermsCheckbox.click();
        System.out.println("Total price: " + totalValue.getText());
        orderWithAnObligationToPayButton.click();

        System.out.println(orderDetails.getText());


    }

}
