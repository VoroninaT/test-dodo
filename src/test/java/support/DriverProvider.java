package support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> createDriver() throws MalformedURLException {
        String appiumHost = System.getProperty("appiumHost");
        URL appiumUrl = new URL(
                String.format(
                        "http://%s:4723/wd/hub",
                        appiumHost == null ? "127.0.0.1" : appiumHost
                )
        );

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "C:\\Users\\Voronina\\AppData\\Local\\Android\\Sdk\\platform-tools\\dodo2.apk");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver<>(appiumUrl, caps);
        return driver;
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

}