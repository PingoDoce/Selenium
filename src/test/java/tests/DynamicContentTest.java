package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.DynamicContentPage;
import utils.BaseTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Tests")
@Feature("Dynamic Content Page")
public class DynamicContentTest extends BaseTest {

    private DynamicContentPage page;

    @Test
    @Story("Sprawdzenie zmieniającej się zawartości po odświeżeniu")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testuje, czy dynamiczna zawartość ulega zmianie po odświeżeniu strony")
    public void testContentChangesOnRefresh() {
        logStep("Otwórz stronę dynamicznej treści");
        driver.get("https://the-internet.herokuapp.com/dynamic_content");

        page = new DynamicContentPage(driver);

        logStep("Zapisz aktualną treść");
        List<String> firstTexts = page.getAllTexts();
        captureScreenshot("Przed odświeżeniem");

        logStep("Odśwież stronę");
        driver.navigate().refresh();

        logStep("Zapisz treść po odświeżeniu");
        List<String> refreshedTexts = page.getAllTexts();
        captureScreenshot("Po odświeżeniu");

        logStep("Porównaj treści przed i po");
        assertEquals(3, firstTexts.size(), "Oczekiwano 3 bloków treści");
        assertEquals(3, refreshedTexts.size(), "Oczekiwano 3 bloków treści po odświeżeniu");

        boolean anyChanged = false;
        for (int i = 0; i < 3; i++) {
            if (!firstTexts.get(i).equals(refreshedTexts.get(i))) {
                anyChanged = true;
                break;
            }
        }

        assertTrue(anyChanged, "Oczekiwano, że co najmniej jeden blok treści się zmieni");

        /*
         * ✅ Playwright (Java) również dobrze radzi sobie z dynamiczną treścią.
         *
         * Można użyć metody `locator().allTextContents()` przed i po odświeżeniu:
         *
         * List<String> textsBefore = page.locator(".row").allTextContents();
         * page.reload();
         * List<String> textsAfter = page.locator(".row").allTextContents();
         *
         * ✔ Playwright ma również bardziej wbudowane metody do oczekiwania na stabilność strony,
         *    co ułatwia testowanie dynamicznych systemów.
         *
         * ➤ Selenium wymaga ręcznego zarządzania momentem przechwycenia treści.
         */
    }
}
