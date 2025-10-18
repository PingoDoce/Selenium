package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.ContextMenuPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI Tests")
@Feature("Context Menu Page")
public class ContextMenuTest extends BaseTest {

    private ContextMenuPage page;

    @Test
    @Story("Kliknięcie prawym przyciskiem i obsługa alertu")
    @Severity(SeverityLevel.NORMAL)
    @Description("Wykonaj kliknięcie prawym przyciskiem na pole i sprawdź alert")
    public void testContextClickShowsAlert() {
        logStep("Otwórz stronę Context Menu");
        driver.get("https://the-internet.herokuapp.com/context_menu");

        page = new ContextMenuPage(driver);

        logStep("Wykonaj kliknięcie prawym przyciskiem myszy");
        page.rightClickHotSpot();

        logStep("Pobierz tekst z alertu i zaakceptuj");
        String alertText = page.getAlertTextAndAccept();
        captureScreenshot("Po kliknięciu prawym przyciskiem");

        assertEquals("You selected a context menu", alertText, "Alert powinien zawierać odpowiedni tekst");

        /*
         * UWAGA: W Playwright taki test jest znacznie prostszy.
         *
         * Playwright umożliwia:
         * - łatwe kliknięcie prawym przyciskiem: locator.click({ button: 'right' })
         * - automatyczne przechwycenie alertu za pomocą page.on('dialog', ...)
         * - brak potrzeby używania obiektów Actions ani switchTo().alert()
         *
         * Przykład (TS):
         * page.on('dialog', dialog => {
         *     expect(dialog.message()).toBe('You selected a context menu');
         *     dialog.accept();
         * });
         * await page.locator('#hot-spot').click({ button: 'right' });
         *
         * ➤ W Selenium potrzeba więcej kodu, a obsługa alertów wymaga dodatkowego przełączania kontekstu.
         */
    }
}
