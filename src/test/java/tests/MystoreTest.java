package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MystoreTest {

    private WebDriver driver;

    @Given("user is on the mystore-testlab website")
    public void userIsOnTheMystoreTestlabWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @When("user clicks Sign in")
    public void userClicksSignIn() {
        WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signIn.click();
    }

    @When("user inputs {string} address and {string} in Log in to your account section")
    public void userInputsAddressAndInLogInToYourAccountSection(String email, String password) {

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

    }

    @And("user clicks Sign In button")
    public void userClicksSignInButton() {
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @When("user clicks Addresses button")
    public void userClicksAddressesButton() {

        WebElement addFirstAddress = driver.findElement(By.id("address-link"));
        addFirstAddress.click();
    }

    @When("user fills {string} as Alias, {string} as Address, {string} as City, {string} as zip postal code, {string} as Country, {string} as Phone")
    public void userNewAddress(String Alias, String Address, String City, String zip_postal_code, String Country, String Phone) {


        WebElement alias = driver.findElement(By.name("alias"));
        alias.sendKeys(Alias);

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys(Address);

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys(City);

        WebElement zipPostalCode = driver.findElement(By.name("postcode"));
        zipPostalCode.sendKeys(zip_postal_code);

        WebElement countryDropDown = driver.findElement(By.name("id_country"));
        countryDropDown.click();

        WebElement countryUnitedKingdom = driver.findElement(By.xpath("//option[@value='17']"));
        countryUnitedKingdom.click();

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(Phone);


    }

    @And("user clicks save")
    public void userClicksRegister() {

        WebElement saveButton = driver.findElement(By.xpath("//button[@class='btn btn-primary float-xs-right']"));
        saveButton.click();
    }

    @Then("Address successfully added! is displayed")
    public void successIsDisplayed() throws InterruptedException {

        WebElement komunikatOutput = driver.findElement(By.xpath("//*[text()='Address successfully added!']"));
        String komunikatSukcesu = komunikatOutput.getText();
        System.out.println(komunikatSukcesu);

        Assertions.assertEquals("Address successfully added!", komunikatSukcesu);

//        Thread.sleep(10000);


    }

    @When("user clicks Delete")
    public void userClicksDeleteAddress() throws InterruptedException {

        WebElement deleteAdress = driver.findElement(By.xpath("//span[text()='Delete']"));
        deleteAdress.click();

//        Thread.sleep(10000);
    }


    @Then("Address successfully deleted! is displayed")
    public void deleteIsDisplayed() {

        WebElement komunikatDeleteOutput = driver.findElement(By.xpath("//*[text()='Address successfully deleted!']"));
        String komunikatDelete = komunikatDeleteOutput.getText();
        System.out.println(komunikatDelete);

        Assertions.assertEquals("Address successfully deleted!", komunikatDelete);

    }

}
