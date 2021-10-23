package tests;

import common.Utils;
import io.cucumber.java.AfterStep;
import io.cucumber.java.it.Ma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import pages.mystore.ClothesPage;
import pages.mystore.LoginPage;
import pages.mystore.MainPage;
import pages.mystore.YourAccount;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Formatter;


public class Zadanie2 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpAndOpenMyStore();

    }

    @Test
    public void registerNewUser() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        YourAccount yourAccount = new YourAccount(driver);
        ClothesPage clothesPage = new ClothesPage(driver);
        String filepath = "target\\zrzuty\\orderScreen" + System.currentTimeMillis() + ".jpg";

        Utils utils = new Utils();
        String mail = "aaaaaaaaaa@wp.pl";
        String password = "qwerty123";

        mainPage.clickSign();
        loginPage.logInToMyStore(mail, password);
        yourAccount.clothesCategory.click();


        String size = "XL";
        String quantity = "5";
        Double price = Double.valueOf(quantity);
        double totalPrice = price * 28.72;


        System.out.println("cena " + String.format("%.2f", totalPrice));

        clothesPage.addClothes(size, quantity);
        try {
            utils.takeSnapShot(driver, filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String orderReference = clothesPage.orderDetails.getText().substring(32, 41);
        System.out.println("Order reference is: " + orderReference);

        driver.findElement(By.xpath("//a[@class='account']")).click();
        driver.findElement(By.xpath("(//i[@class='material-icons'])[4]")).click();

        WebElement correctOrderNumber = driver.findElement(By.xpath("//th[text()='" + orderReference + "']"));
        System.out.println("Correct order number: " + correctOrderNumber.getText());

        WebElement correcInvoice = driver.findElement(By.xpath("(//span[@class='label label-pill bright'])[1]"));
        WebElement correctTotalValue = driver.findElement(By.xpath("(//td[@class='text-xs-right'])[1]"));

        System.out.println(correctTotalValue.getText());


        Assertions.assertEquals(orderReference, correctOrderNumber.getText());
        Assertions.assertEquals("Awaiting check payment", correcInvoice.getText());
        Assertions.assertEquals(String.format("%.2f", totalPrice).replaceAll(",", "."),correctTotalValue.getText().replaceAll("€", "") );


    }

//        @AfterEach


}



