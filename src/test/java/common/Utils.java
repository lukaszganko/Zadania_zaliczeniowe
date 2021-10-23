package common;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
//import java.io.File;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;


public class Utils {
//    protected static WebDriver driver;

    public static   WebDriver setUpAndOpenMyStore() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        try {
//            takeSnapShot(driver, "C:\\zrz\\www.jpg") ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return driver;
    }


    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileHandler.copy(SrcFile, DestFile);

    }

}








