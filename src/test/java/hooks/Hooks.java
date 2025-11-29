package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import drivers.DriverManager;
import utils.ReadPropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    AndroidDriver androidDriver;
    Properties prop=new Properties();
    String configPropertiesFile="src/test/resources/config.properties";

    @Before
    public void SetUpApplication() {
        prop = ReadPropertyFile.readProperties(configPropertiesFile);
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName",prop.getProperty("device.serialNumber"));
        caps.setCapability("automationName","UIautomator2");
        caps.setCapability("appium:app",  prop.getProperty("app.path"));
        caps.setCapability("appPackage", "com.reddit.frontpage");
        caps.setCapability("appActivity", "com.reddit.launch.main.MainActivity");
        caps.setCapability("autoGrantPermissions", true);


        androidDriver = new AndroidDriver(caps);
        DriverManager.setDriver(androidDriver);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }





    @After
    public void TearDownApplication(){
        if (androidDriver!=null) androidDriver.quit();
        prop=null;

    }

}
