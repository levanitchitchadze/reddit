package drivers;

import hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Stores and manages an instance of the driver
public class DriverManager {

    protected static AndroidDriver androidDriver;
    private static WebDriverWait wait;


    public static void setDriver(AndroidDriver androidDriver) {
        DriverManager.androidDriver = androidDriver;
        if (wait == null) {
            wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        }
    }

    public static AndroidDriver getDriver() {
        if (androidDriver == null) {
            Hooks.SetUpApplication();
        }
        return androidDriver;
    }

    public static WebDriverWait waitFor() {
        return wait;
    }


    public static void timeout(int time) {
        synchronized (androidDriver) {
            try {
                wait.wait(time);

            } catch (InterruptedException e) {
                throw new RuntimeException("Problem during wait" + e);
            }
        }
    }
}
