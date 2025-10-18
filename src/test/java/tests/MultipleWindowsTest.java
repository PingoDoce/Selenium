package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.MultipleWindowsPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleWindowsTest extends BaseTest {

    @Test
    @Description("Sprawdza, czy po kliknięciu 'Click Here' otwiera się nowe okno z właściwym nagłówkiem")
    public void testNewWindowOpensCorrectly() {
        MultipleWindowsPage page = new MultipleWindowsPage(driver);
        page.navigate();
        logStep("Przechodzimy na stronę Multiple Windows");

        String originalWindow = page.getCurrentWindowHandle();
        page.clickHere();
        logStep("Klikamy w link 'Click Here'");

        for (String handle : page.getAllWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                page.switchToWindow(handle);
                logStep("Przełączamy się do nowego okna");
                break;
            }
        }

        String newHeader = page.getHeaderText();
        assertEquals("New Window", newHeader);
        logStep("Nagłówek nowego okna to 'New Window'");
    }
}
