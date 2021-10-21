package tests;

import common.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.xpath;

public class MystoreTest extends Utils {

    private WebDriver driver;


    @Given("user is on the mystore-testlab website")
    public void userIsOnTheMystoreTestlabWebsite() {

        driver = Utils.setUpAndOpenMyStore();
//        driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @When("user clicks Sign in")
    public void userClicksSignIn() {
        WebElement signIn = driver.findElement(xpath("//span[text()='Sign in']"));
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

        WebElement Address = driver.findElement(xpath("(//span[@class='link-item'])[2]"));
        Address.click();

        WebElement createNewAddress = driver.findElement(xpath("//span[text()='Create new address']"));
        createNewAddress.click();
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

        Select countryDropDown = new Select(driver.findElement(By.name("id_country")));
        countryDropDown.selectByVisibleText(Country);

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(Phone);
    }

    @And("user clicks save")
    public void userClicksRegister() {

        WebElement saveButton = driver.findElement(xpath("//button[@class='btn btn-primary float-xs-right']"));
        saveButton.click();
    }

    @Then("Address is correctly added {string} {string} {string} {string} {string} {string}")
    public void successIsDisplayed(String Alias, String Address, String City, String zip_postal_code, String Country, String Phone) {

        WebElement addedAddress = driver.findElement(xpath("(//div[@class='address-body'])[2]"));
        System.out.println(addedAddress.getText());

        String sprawdzany_adres = Alias + "\n" + "Lukas Ganko" + "\n" + Address + "\n" + City + "\n" + zip_postal_code + "\n" + Country + "\n" + Phone;

        System.out.println(sprawdzany_adres);
        Assertions.assertEquals(sprawdzany_adres, addedAddress.getText());

    }

    @When("user clicks Delete")
    public void userClicksDeleteAddress() {

        WebElement deleteAdress = driver.findElement(xpath("(//span[text()='Delete'])[2]"));
        deleteAdress.click();

    }

    @Then("Address successfully deleted! is displayed")
    public void deleteIsDisplayed() {

        WebElement komunikatDeleteOutput = driver.findElement(xpath("//*[text()='Address successfully deleted!']"));
        String komunikatDelete = komunikatDeleteOutput.getText();
        System.out.println(komunikatDelete);

        Assertions.assertEquals("Address successfully deleted!", komunikatDelete);

    }

}
