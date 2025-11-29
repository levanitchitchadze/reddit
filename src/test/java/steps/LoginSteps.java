package steps;

import drivers.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ReadPropertyFile;

import java.util.Properties;


//Login page step definitions
public class LoginSteps {


    private LoginPage loginPage;

    private Properties prop = new Properties();
    private String configPropertiesFile = "src/test/resources/config.properties";


    @Given("the login page is open")
    public void loginPageIsOpen() {
        loginPage = new LoginPage();
        System.out.println("Move To login page? " + loginPage.moveToPage());

    }


    @When("the user enters valid credentials")
    public void enterValidCredentials() {
        prop = ReadPropertyFile.readProperties(configPropertiesFile);
        String email = prop.getProperty("user.email");
        String password = prop.getProperty("user.password");
        loginPage.login(email, password);

    }

    @Then("the user is logged in successfully")
    public void loggedInSuccessfully() {
        assert loginPage.checkLogin();

    }


}
