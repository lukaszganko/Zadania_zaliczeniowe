package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount {
    public WebDriver driver;

    @FindBy(id = "address-link")
    public WebElement addFirstAddress;

    @FindBy(xpath = "(//span[@class='link-item'])[2]")
    public WebElement address;

    @FindBy(xpath = "(//i[@class='material-icons'])[4]")
    public WebElement orderHistoryAndDetails;

    @FindBy(xpath = "//span[text()='Create new address']")
    public WebElement createNewAddress;

    @FindBy(xpath = "(//span[text()='Delete'])[2]")
    public WebElement deleteAdress;

    @FindBy(xpath = "//li[@class='category'][@id='category-3']")
    public WebElement clothesCategory;

    @FindBy(xpath = "(//div[@class='address-body'])[2]")
    public WebElement addedAddress;

    @FindBy(xpath = "//*[text()='Address successfully deleted!']")
    public WebElement komunikatDelete;

    @FindBy(xpath = "(//span[@class='label label-pill bright'])[1]")
    public WebElement correcInvoice;

    @FindBy(xpath = "(//td[@class='text-xs-right'])[1]")
    public WebElement correctTotalValue;


    public YourAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
