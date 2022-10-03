package screen;

import com.codeborne.selenide.Selenide;
import elements.Element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import support.DriverProvider;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

@Slf4j
public class MainPage {

    public Element countryName = $("[resource-id='ru.dodopizza.app:id/country_name']");
    public Element choosePizza = $x("//[android.widget.LinearLayout[@content-desc='Пицца']/android.widget.TextView]");

    public static MainPage at() {
        MainPage screen = page(MainPage.class);
        screen.countryName.shouldBe(visible);
        return screen;
    }

    public void countrySelect(String text) {
        Element country = $x(".//*[@text='" + text + "']");
        country.click();
    }

    public void citySelect(String text) {
        Element city = $x(".//*[@text='" + text + "']");
        city.click();
    }


    public static Element $(String cssSelector) {
        Element result = new Element(Selenide.$(cssSelector));
        result.locator = By.cssSelector(cssSelector);
        return result;
    }

    public static Element $x(String xpath) {
        Element result = new Element(Selenide.$x(xpath));
        result.locator = By.xpath(xpath);
        return result;
    }

    public void swipeDown() {
        log.info("swipe down");
        Dimension d = DriverProvider.getDriver().manage().window().getSize();
        int screenWidth = d.getWidth();
        int screenHeight = d.getHeight();
        swipe(
                new Point(screenWidth / 2, screenHeight * 3 / 4),
                new Point(screenWidth / 2, screenHeight / 4)
        );
        log.info("swipe FINISHED");
    }

    public void swipe(Point sourcePoint, Point targetPoint) {
        new TouchAction<>(DriverProvider.getDriver())
                .press(PointOption.point(sourcePoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(targetPoint))
                .release().perform();
    }

    public Element getChoosePizza() {
        return $x(".//android.widget.LinearLayout[@content-desc=\"Пицца\"]/android.widget.TextView");
    }
}

