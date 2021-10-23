package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddress {
    private WebDriver driver;


    @FindBy (name ="alias")
    public WebElement aliasInput;

    @FindBy(name = "address1")
    public WebElement addressInput;

    @FindBy (name = "city")
    public WebElement cityInput;

    @FindBy (name = "postcode")
    public WebElement zipPostalCodeInput;

    @FindBy (name = "id_country")
    public WebElement countryDropDownInput;

//    @FindBy
//    WebElement countryUnitedKingdom = driver.findElement(By.xpath("//option[@value='17']"));

    @FindBy (name="phone")
    public WebElement phoneInput;

    @FindBy (xpath = "//button[@class='btn btn-primary float-xs-right']")
    public WebElement saveButton;


    public NewAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void createNewAddress(String alias, String address, String city, String zip_postal_code, String country, String phone){
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipPostalCodeInput.sendKeys(zip_postal_code);
        Select countryDropDown = new Select(countryDropDownInput);
        countryDropDown.selectByVisibleText(country);
        phoneInput.sendKeys(phone);
    }
}
