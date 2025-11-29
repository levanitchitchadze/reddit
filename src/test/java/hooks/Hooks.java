package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    AndroidDriver androidDriver;
    Properties prop=new Properties();
    String configPropertiesFile="config.properties";

    @Before
    public void SetUpApplication(){
        readProperties();
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName",prop.getProperty("device.serialNumber"));
        caps.setCapability("automationName","UIautomator2");

        androidDriver = new AndroidDriver(caps);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    private void readProperties() {
        try(FileInputStream file=new FileInputStream(configPropertiesFile)) {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Can't open properties file, check file location:\n"+configPropertiesFile+"\n"+e);
        }

    }


    @After
    public void TearDownApplication(){
        if (androidDriver!=null) androidDriver.quit();
        prop=null;

    }

}
