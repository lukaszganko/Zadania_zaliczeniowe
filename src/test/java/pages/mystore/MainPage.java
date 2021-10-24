package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement account;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSign() {
        signIn.click();
    }


}
