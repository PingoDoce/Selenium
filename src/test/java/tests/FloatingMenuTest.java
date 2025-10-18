package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.FloatingMenuPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

public class FloatingMenuTest extends BaseTest {

    @Test
    @DisplayName("Menu powinno być widoczne nawet po przewinięciu strony")
    public void testFloatingMenuVisibilityOnScroll() {
        FloatingMenuPage page = new FloatingMenuPage(driver);
        page.open();

        assertTrue(page.isMenuVisible(), "Menu powinno być widoczne po załadowaniu strony");

        page.scrollDown();

        // Po przewinięciu – nadal powinno być widoczne
        assertTrue(page.isMenuVisible(), "Menu powinno być widoczne po przewinięciu strony w dół");
    }

    @Test
    @DisplayName("Linki w menu powinny być poprawne")
    public void testMenuLinksAreValid() {
        FloatingMenuPage page = new FloatingMenuPage(driver);
        page.open();

        for (WebElement link : page.getMenuLinks()) {
            String href = link.getAttribute("href");
            assertNotNull(href, "Każdy link powinien mieć atrybut href");
            assertTrue(href.contains("#"), "Każdy link powinien być lokalnym odnośnikiem (zawierać #)");
        }
    }
}
