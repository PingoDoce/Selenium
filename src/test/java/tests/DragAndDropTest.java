package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.DragAndDropPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI Tests")
@Feature("Drag and Drop Page")
public class DragAndDropTest extends BaseTest {

    private DragAndDropPage page;

    @Test
    @Story("Drag & Drop A → B")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sprawdza, czy po przeciągnięciu kolumny A na B zawartość zostaje zamieniona")
    public void testDragAtoB() {
        logStep("Otwórz stronę Drag and Drop");
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        page = new DragAndDropPage(driver);

        logStep("Sprawdź początkowy stan nagłówków");
        String beforeA = page.getHeaderOfColumnA();
        String beforeB = page.getHeaderOfColumnB();

        assertEquals("A", beforeA);
        assertEquals("B", beforeB);

        logStep("Wykonaj przeciągnięcie A → B");
        page.dragAtoB();
        captureScreenshot("Po przeciągnięciu");

        logStep("Sprawdź nowy stan nagłówków");
        String afterA = page.getHeaderOfColumnA();
        String afterB = page.getHeaderOfColumnB();

        assertEquals("B", afterA, "Po przeciągnięciu kolumna A powinna mieć nagłówek B");
        assertEquals("A", afterB, "Po przeciągnięciu kolumna B powinna mieć nagłówek A");

        /*
         * ⚠️ UWAGA: Drag & Drop w Selenium (Java) wymaga użycia JavaScript injection,
         * ponieważ natywna metoda Actions().dragAndDrop(...) nie działa na tej stronie.
         *
         * ➤ Powód: strona używa niestandardowej implementacji DnD w JS, która nie reaguje
         *    na klasyczne eventy Selenium (mousedown, mousemove, mouseup).
         *
         * ✔ PLAYWRIGHT (Java) obsługuje drag & drop natywnie przez metodę:
         *    page.locator("#column-a").dragTo(page.locator("#column-b"));
         *
         * ➤ Działa stabilnie i bez potrzeby pisania własnych skryptów JS.
         *
         * ➤ To doskonały przykład przewagi Playwright nad Selenium w testowaniu
         *    nowoczesnych interfejsów użytkownika z obsługą zaawansowanych zdarzeń DOM.
         */
    }
}
