package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;


@Slf4j
public class Element {

    public SelenideElement se;
    public static String accessibilityLabel;
    public By locator;

    public Element(SelenideElement se) {
        this.se = se;
    }

    public void click() {
        log.info("clicking element '{}'", elementName());
        se.click();
    }

    public void shouldBe(Condition... condition) {
        se.shouldBe(condition);
    }


    public String elementName() {
        return accessibilityLabel != null ? accessibilityLabel : this.toString();
    }

}