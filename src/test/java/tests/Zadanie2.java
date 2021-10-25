package tests;

import common.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import pages.mystore.ClothesPage;
import pages.mystore.LoginPage;
import pages.mystore.MainPage;
import pages.mystore.YourAccount;


public class Zadanie2 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpAndOpenMyStore();
    }

    @Test
    public void logInAndShopping(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        YourAccount yourAccount = new YourAccount(driver);
        ClothesPage clothesPage = new ClothesPage(driver);
        String filepath = "target\\orderScreen" + System.currentTimeMillis() + ".jpg";

        Utils utils = new Utils();
        String mail = "aaaaaaaaaa@wp.pl";
        String password = "qwerty123";

        mainPage.clickSign();
        loginPage.logInToMyStore(mail, password);
        yourAccount.clothesCategory.click();

        String size = "XL";
        String quantity = "5";
        Double quantityCalculations = Double.valueOf(quantity);
        double totalPrice = quantityCalculations * 28.72;


        System.out.println("The price for the order " + String.format("%.2f", totalPrice));

        clothesPage.addClothes(size, quantity);
        try {
            utils.takeSnapShot(driver, filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String orderReference = clothesPage.orderDetails.getText().substring(32, 41);
        System.out.println("Order reference is: " + orderReference);

        mainPage.account.click();
        yourAccount.orderHistoryAndDetails.click();
        WebElement correctOrderNumber = driver.findElement(By.xpath("//th[text()='" + orderReference + "']"));
        System.out.println("Correct order number: " + correctOrderNumber.getText());
        System.out.println("Correct total price: " + yourAccount.correctTotalValue.getText());

        Assertions.assertEquals(orderReference, correctOrderNumber.getText());
        Assertions.assertEquals("Awaiting check payment", yourAccount.correcInvoice.getText());
        Assertions.assertEquals(String.format("%.2f", totalPrice).replaceAll(",", "."), yourAccount.correctTotalValue.getText().replaceAll("€", ""));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
