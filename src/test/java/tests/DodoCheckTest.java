package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import screen.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

@Slf4j
public class DodoCheckTest extends BaseTest {

    @Test
    void dodoMainPageCheck() throws Exception {
        MainPage mainPage = new MainPage();
        MainPage.at();
        mainPage.countrySelect("Russia");
        mainPage.citySelect("Москва");

        for (int i = 0; i < 60; i++) {
            try {
                mainPage.getChoosePizza().shouldBe(visible);
            } catch (Throwable e) {
                log.info("NOT VISIBLE: {}", e.getMessage());
                Thread.sleep(5000);
                continue;
            }
            log.info("VISIBLE");
            break;
        }
        mainPage.swipeDown();
    }
}
