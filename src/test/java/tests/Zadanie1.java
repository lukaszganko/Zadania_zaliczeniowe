package tests;

import common.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.mystore.LoginPage;
import pages.mystore.MainPage;
import pages.mystore.NewAddress;
import pages.mystore.YourAccount;


public class Zadanie1 {
    private WebDriver driver;

    @Given("user is on the mystore-testlab website")
    public void userIsOnTheMystoreTestlabWebsite() {

        driver = Utils.setUpAndOpenMyStore();
    }

    @When("user clicks Sign in")
    public void userClicksSignIn() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSign();
    }

    @When("user inputs {string} address and {string} in Log in to your account section")
    public void userInputsAddressAndInLogInToYourAccountSection(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logInToMyStoreCucumber(email, password);
    }

    @And("user clicks Sign In button")
    public void userClicksSignInButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInButton.click();
    }

    @When("user clicks Addresses button")
    public void userClicksAddressesButton() {
        YourAccount yourAccount = new YourAccount(driver);

        yourAccount.address.click();
        yourAccount.createNewAddress.click();
    }

    @When("user fills {string} as Alias, {string} as Address, {string} as City, {string} as zip postal code, {string} as Country, {string} as Phone")
    public void userNewAddress(String Alias, String Address, String City, String zip_postal_code, String Country, String Phone) {
        NewAddress newAddress = new NewAddress(driver);

        newAddress.createNewAddress(Alias, Address, City, zip_postal_code, Country, Phone);
    }

    @And("user clicks save")
    public void userClicksSave() {
        NewAddress newAddress = new NewAddress(driver);

        newAddress.saveButton.click();
    }

    @Then("Address is correctly added {string} {string} {string} {string} {string} {string}")
    public void addressIsCorrectlyAdded(String Alias, String Address, String City, String zip_postal_code, String Country, String Phone) {
        YourAccount yourAccount = new YourAccount(driver);

        String sprawdzany_adres = Alias + "\n" + "Lukas Ganko" + "\n" + Address + "\n" + City + "\n" + zip_postal_code + "\n" + Country + "\n" + Phone;

        System.out.println(sprawdzany_adres);
        Assertions.assertEquals(sprawdzany_adres, yourAccount.addedAddress.getText());
    }

    @When("user clicks Delete")
    public void userClicksDeleteAddress() {
        YourAccount yourAccount = new YourAccount(driver);

        yourAccount.deleteAdress.click();
    }

    @Then("Address successfully deleted! is displayed")
    public void deleteIsDisplayed() {
        YourAccount yourAccount = new YourAccount(driver);

        Assertions.assertEquals("Address successfully deleted!", yourAccount.komunikatDelete.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}