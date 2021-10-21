package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount {

    public WebDriver driver;

    @FindBy(id = "address-link")
    public WebElement addFirstAddress;

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteAdress;

    @FindBy(xpath = "//li[@class='category'][@id='category-3']")
    public WebElement clothesCategory;


    public void findClothes(){
        clothesCategory.click();

    }


    public YourAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
