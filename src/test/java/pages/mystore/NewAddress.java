package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddress {
    private WebDriver driver;


    @FindBy
    WebElement alias = driver.findElement(By.name("alias"));

    @FindBy
    WebElement address = driver.findElement(By.name("address1"));

    @FindBy
    WebElement city = driver.findElement(By.name("city"));

    @FindBy
    WebElement zipPostalCode = driver.findElement(By.name("postcode"));

    @FindBy
    WebElement countryDropDown = driver.findElement(By.name("id_country"));

    @FindBy
    WebElement countryUnitedKingdom = driver.findElement(By.xpath("//option[@value='17']"));

    @FindBy
    WebElement phone = driver.findElement(By.name("phone"));

    @FindBy
    WebElement saveButton = driver.findElement(By.name("submitAddress"));


    public NewAddress(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
