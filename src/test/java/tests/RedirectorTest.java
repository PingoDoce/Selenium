package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.RedirectorPage;
import utils.BaseTest;

public class RedirectorTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test przekierowania po kliknięciu w link 'here'")
    public void testRedirect() {
        driver.get("https://the-internet.herokuapp.com/redirector");

        RedirectorPage page = new RedirectorPage(driver);
        page.clickHereLink();

        // Oczekujemy, że po przekierowaniu trafimy na /status_codes
        String redirectedUrl = page.getCurrentUrl();
        Assertions.assertTrue(redirectedUrl.contains("/status_codes"),
                "URL po przekierowaniu powinien zawierać '/status_codes'");
    }
}
