package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import support.DriverProvider;
import java.net.MalformedURLException;

public class BaseTest {
    private AndroidDriver<AndroidElement> driver;

    @BeforeSuite
    void beforeAll() {
        Configuration.timeout = 15000;
    }

    @BeforeMethod
    void beforeEach() throws MalformedURLException {
        driver = DriverProvider.createDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.unlockDevice();
    }
}
