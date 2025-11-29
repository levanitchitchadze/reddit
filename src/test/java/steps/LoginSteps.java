package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ReadPropertyFile;

import java.util.Properties;

public class LoginSteps {


    private LoginPage loginPage=new LoginPage();

    private Properties prop=new Properties();
    private String configPropertiesFile="src/test/resources/config.properties";

    @Given("the login page is open")
    public void the_login_page_is_open() throws InterruptedException {
        System.out.println("Move To login page? "+loginPage.moveToPage());

    }


    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        prop= ReadPropertyFile.readProperties(configPropertiesFile);
        String email = prop.getProperty("user.email");
        String password =prop.getProperty("user.password");
        loginPage.login(email,password);

    }
    @Then("the user is logged in successfully")
    public void the_user_is_logged_in_successfully() {
        assert loginPage.checkLogin();

    }



}
