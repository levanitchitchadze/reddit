package pages;

import drivers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.Assertion;

import static drivers.DriverManager.waitFor;

@Slf4j
public class LoginPage {

    private AndroidDriver driver;
    private final Assertion assertion=new Assertion();

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Use email or username\"]")
    private WebElement USE_EMAIL_AND_PASSWORD_BTN;
    @FindBy(id = "com.reddit.frontpage:id/inner_user_icon")
    private WebElement ADD_ACCOUNT_BTN;

    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text_auto_fill\"])[1]")
    private WebElement EMAIL_INP;
    @FindBy(xpath = "(//android.widget.EditText[@resource-id=\"text_auto_fill\"])[2]")
    private WebElement PASSWORD_INP;
    @FindBy(xpath = "//android.view.View[@resource-id=\"continue_button\"]")
    private WebElement CONTINUE_BTN;

    @FindBy(id = "inner_peeking_snoovatar")
    private WebElement AVATAR;



    public LoginPage(){
        driver= DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean moveToPage(){

        try {
            USE_EMAIL_AND_PASSWORD_BTN.click();


        }catch (NotFoundException nfe){
            throw new RuntimeException("Can't find element to move login page"+nfe);

        }

        try {
            ADD_ACCOUNT_BTN.click();
        }catch (NotFoundException ignored){
            System.out.println("Add account button may not appear in application");
        }
        return true;



    }

    public void login(String email,String password){
        try {
            EMAIL_INP.sendKeys(email);
            PASSWORD_INP.sendKeys(password);
            CONTINUE_BTN.click();

        }catch (NotFoundException nfe){
            throw new RuntimeException("Can't find element to login "+nfe);

        }

    }


    public boolean checkLogin(){
        try {
            waitFor().until(ExpectedConditions.visibilityOf(AVATAR));
            log.info("Avatar is visible");
            log.info("Logedin successfully");
            return AVATAR.isDisplayed();
        }catch (NotFoundException nfe){
             log.error("You are not loged in");
             return false;
        }
    }

}
