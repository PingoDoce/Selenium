package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.BasicAuthPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("UI Tests")
@Feature("Basic Auth Page")
public class BasicAuthTest extends BaseTest {

    private BasicAuthPage page;

    @Test
    @Story("Zaloguj się przez Basic Auth")
    @Severity(SeverityLevel.BLOCKER)
    @Description("UI test potwierdzający logowanie do strony chronionej Basic Auth przez adres URL")
    public void testBasicAuthThroughUI() {
        // Uwaga:
        // Selenium NIE obsługuje natywnych popupów systemowych (np. Basic Auth),
        // ponieważ nie są częścią DOM – nie da się ich kliknąć ani wypełnić z poziomu WebDrivera.
        // Dlatego używamy alternatywy: wbudowanie danych logowania w URL (https://user:pass@host)
        // co jest jedynym możliwym podejściem UI dla tego typu autoryzacji.

        String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

        logStep("Przejdź do strony z Basic Auth z danymi logowania w adresie URL");
        driver.get(url);
        page = new BasicAuthPage(driver);

        logStep("Sprawdź, czy pojawił się komunikat powitalny");
        String message = page.getSuccessMessage();
        captureScreenshot("Po zalogowaniu");

        assertTrue(message.contains("Congratulations"), "Powinien pojawić się komunikat 'Congratulations!'");
    }

}
