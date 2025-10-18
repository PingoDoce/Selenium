package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.RepeatedTest;
import pages.NotificationMessagePage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationMessageTest extends BaseTest {

    @RepeatedTest(5) // uruchom kilka razy, bo wiadomość jest losowa
    @Description("Sprawdza, czy pojawia się komunikat po kliknięciu 'Click here'")
    public void testNotificationAppears() {
        NotificationMessagePage page = new NotificationMessagePage(driver);
        page.navigate();
        logStep("Otwieramy stronę z powiadomieniem");

        page.clickHere();
        logStep("Klikamy w 'Click here'");

        assertTrue(page.isNotificationVisible(), "Powiadomienie powinno być widoczne");
        logStep("Powiadomienie: " + page.getNotificationText());
    }
}
