package pages.mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount {

    private WebDriver driver;

    @FindBy
    WebElement addFirstAddress = driver.findElement(By.id("address-link"));
//    WebElement addFirstAddress = driver.findElement(By.xpath("//i[text()='\uE567']"));

    WebElement deleteAdress = driver.findElement(By.xpath("span[text()='Delete']"));



    public YourAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
