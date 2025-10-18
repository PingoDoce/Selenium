package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.DropdownPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI Tests")
@Feature("Dropdown Page")
public class DropdownTest extends BaseTest {

    private DropdownPage page;

    @Test
    @Story("Wybór opcji z rozwijanego menu")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testuje wybór dostępnych opcji z dropdowna")
    public void testDropdownSelection() {
        logStep("Przejdź do strony Dropdown");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        page = new DropdownPage(driver);

        logStep("Wybierz Option 1");
        page.selectByVisibleText("Option 1");
        captureScreenshot("Option 1 selected");
        assertEquals("Option 1", page.getSelectedOptionText());

        logStep("Wybierz Option 2");
        page.selectByVisibleText("Option 2");
        captureScreenshot("Option 2 selected");
        assertEquals("Option 2", page.getSelectedOptionText());

        /*
         * ✅ Playwright (Java) również umożliwia wybór opcji z dropdowna bardzo prosto:
         *
         * page.locator("#dropdown").selectOption("1");
         *
         * ✔ W Playwright wartości opcji (`value`) można podawać jako tekst, tablicę lub obiekt,
         *    a testy dropdownów są szybkie i niezawodne.
         *
         * ➤ Selenium wymaga utworzenia obiektu Select i operuje na widocznych tekstach.
         * ➤ Playwright działa bardziej „frontendowo”, odzwierciedlając zachowanie użytkownika.
         *
         * To dobry przypadek do porównania ergonomii API przy prostym formularzu.
         */
    }
}
