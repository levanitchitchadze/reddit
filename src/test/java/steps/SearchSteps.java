package steps;

import com.github.javafaker.Faker;
import drivers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import pages.LoginPage;
import utils.ReadPropertyFile;

import java.util.Properties;

//Search functionality step definitions
//There is only includes one element so it doesn't need Page class
public class SearchSteps {

    private LoginPage loginPage = new LoginPage();
    private static final Assertion assertion = new Assertion();

    private static final Faker faker = new Faker();
    private final AndroidDriver driver = DriverManager.getDriver();
    private Properties prop = new Properties();
    private String configPropertiesFile = "src/test/resources/config.properties";

    @FindAll({
            @FindBy(id = "action_search"),
            @FindBy(id = "feed_control_search_icon")
    })
    private WebElement SEARCH_ICON;

    @FindBy(id = "search")
    private WebElement SEARCH_FIELD;

    @FindBy(xpath = "//*[@resource-id=\"tab_unit\"]/*[@text=\"Posts\"]")
    private WebElement POST_BTN;

    @Given("the search field is visible")
    public void the_application_is_open() {
        prop = ReadPropertyFile.readProperties(configPropertiesFile);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        try {
            SEARCH_ICON.isDisplayed();
        } catch (NotFoundException ignored) {
            loginPage.moveToPage();
            loginPage.login(prop.getProperty("user.email"), prop.getProperty("user.password"));

        }

    }

    @When("the user enters text in the search field")
    public void the_user_enters_text_in_the_search_field() {
        SEARCH_ICON.click();
        SEARCH_FIELD.sendKeys(faker.superhero().name());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Then("the user is redirected to the search results page")
    public void the_user_is_redirected_to_the_search_results_page() {
        assertion.assertTrue(POST_BTN.isDisplayed(), "The profile page could not be loaded");
    }
}
