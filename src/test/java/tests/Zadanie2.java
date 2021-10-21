package tests;

import common.Utils;
import io.cucumber.java.AfterStep;
import io.cucumber.java.it.Ma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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




public class Zadanie2 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpAndOpenMyStore();
        driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @Test
    public void registerNewUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        YourAccount yourAccount = new YourAccount(driver);
        ClothesPage clothesPage = new ClothesPage(driver);
        String filepath = "target\\zrzuty\\orderScreen"+ System.currentTimeMillis()+".jpg";

        Utils utils = new Utils();
        String mail = "aaaaaaaaaa@wp.pl";
        String password = "qwerty123";

        mainPage.clickSign();
        loginPage.logInToMyStore(mail, password);
        yourAccount.clothesCategory.click();
        clothesPage.addClothes("XL", "2");
        try {
            utils.takeSnapShot(driver, filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//        @AfterEach


}



