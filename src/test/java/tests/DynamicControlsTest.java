package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.DynamicControlsPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Tests")
@Feature("Dynamic Controls Page")
public class DynamicControlsTest extends BaseTest {

    private DynamicControlsPage page;

    @Test
    @Story("Ukrywanie i pokazywanie checkboxa")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testuje usuwanie i dodawanie checkboxa oraz wyświetlanie komunikatów")
    public void testCheckboxAppearsAndDisappears() {
        logStep("Otwórz stronę Dynamic Controls");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        page = new DynamicControlsPage(driver);

        logStep("Kliknij Remove");
        page.clickRemoveAddButton();
        page.waitForCheckboxToDisappear();
        captureScreenshot("Po usunięciu checkboxa");
        assertFalse(page.isCheckboxVisible());
        assertEquals("It's gone!", page.getMessage());

        logStep("Kliknij Add");
        page.clickRemoveAddButton();
        page.waitForCheckboxToAppear();
        captureScreenshot("Po dodaniu checkboxa");
        assertTrue(page.isCheckboxVisible());
        assertEquals("It's back!", page.getMessage());
    }

    @Test
    @Story("Włączanie i wyłączanie pola input")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testuje przełączanie aktywności pola tekstowego")
    public void testEnableDisableInputField() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        page = new DynamicControlsPage(driver);

        logStep("Kliknij Enable");
        page.clickEnableDisableButton();
        page.waitForInputToBeEnabled();
        captureScreenshot("Input odblokowany");
        assertTrue(page.isInputEnabled());
        assertEquals("It's enabled!", page.getMessage());

        logStep("Kliknij Disable");
        page.clickEnableDisableButton();
        page.waitForInputToBeDisabled();
        captureScreenshot("Input zablokowany");
        assertFalse(page.isInputEnabled());
        assertEquals("It's disabled!", page.getMessage());

        /*
         * ✅ Playwright (Java) radzi sobie bardzo dobrze z dynamicznymi kontrolkami:
         *
         * page.getByRole("button", new RoleOptions().setName("Enable")).click();
         * page.locator("input[type='text']").waitFor(new Locator.WaitForOptions().setState(Attached));
         *
         * ✔ Playwright automatycznie czeka na zmiany stanu DOM, co upraszcza testy dynamicznych elementów.
         *
         * ➤ W Selenium trzeba ręcznie zarządzać WebDriverWait, co jest bardziej podatne na błędy.
         */
    }
}
