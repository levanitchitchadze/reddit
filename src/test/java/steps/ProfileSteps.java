package steps;

import drivers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import pages.LoginPage;
import utils.ReadPropertyFile;

import java.util.Properties;

public class ProfileSteps {
    private LoginPage loginPage=new LoginPage();
    private static Assertion assertion=new Assertion();
    private AndroidDriver driver= DriverManager.getDriver();
    private String AVATAR_SELECTOR="inner_peeking_snoovatar";
    @FindBy(id = "inner_peeking_snoovatar")
    private WebElement AVATAR;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Profile\"]\n")
    private WebElement PROFILE_BTN;

    @FindBy(id = "snoovatar")
    private WebElement LARGE_AVATAR_IMAGE;

    private Properties prop=new Properties();
    private String configPropertiesFile="src/test/resources/config.properties";



    @Given("the user avatar is visible")
    public void the_application_is_open() {
        prop= ReadPropertyFile.readProperties(configPropertiesFile);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        try {
            driver.findElement(By.id(AVATAR_SELECTOR)).isDisplayed();
        }catch (NotFoundException ignored){
            loginPage.moveToPage();
            loginPage.login(prop.getProperty("user.email"),prop.getProperty("user.password"));

        }

    }

    @When("the user taps the avatar")
    public void the_user_taps_the_avatar() {
        try {
            AVATAR.click();

        }catch (NotFoundException nfe){
            throw new RuntimeException("Can't find avatar element: "+nfe);
        }
    }

    @When("the user taps the View Profile button")
    public void the_user_taps_the_button() {
        try {
            PROFILE_BTN.click();
        }catch (NotFoundException nfe){
            throw new RuntimeException("Can't find profile button in sidebar: "+nfe);
        }
    }

    @Then("the user is redirected to the profile page")
    public void the_user_is_redirected_to_the_profile_page() {
        assertion.assertTrue(LARGE_AVATAR_IMAGE.isDisplayed(),"The profile page could not be loaded");
    }
}
