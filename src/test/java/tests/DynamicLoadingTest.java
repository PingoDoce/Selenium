package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.DynamicLoadingPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Tests")
@Feature("Dynamic Loading Page")
public class DynamicLoadingTest extends BaseTest {

    @Test
    @Story("Example 1: Element hidden in DOM")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testuje poprawne ładowanie elementu, który był ukryty w DOM (Example 1)")
    public void testDynamicLoadingExample1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        logStep("Kliknij przycisk Start");
        page.clickStart();

        logStep("Czekaj na koniec ładowania");
        page.waitForLoadingToFinish();

        captureScreenshot("Po załadowaniu (Example 1)");
        assertEquals("Hello World!", page.getResultText());
    }

    @Test
    @Story("Example 2: Element not in the DOM until loaded")
    @Severity(SeverityLevel.NORMAL)
    @Description("Testuje ładowanie elementu dynamicznie dodawanego do DOM (Example 2)")
    public void testDynamicLoadingExample2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        logStep("Kliknij przycisk Start");
        page.clickStart();

        logStep("Czekaj na koniec ładowania");
        page.waitForLoadingToFinish();

        captureScreenshot("Po załadowaniu (Example 2)");
        assertEquals("Hello World!", page.getResultText());

        /*
         * ✅ Playwright (Java) oferuje bardzo prostą synchronizację z dynamicznymi elementami:
         *
         * page.getByText("Start").click();
         * page.getByText("Hello World!").waitFor();
         *
         * ✔ Playwright sam czeka na pojawienie się elementu, co czyni testy bardziej stabilnymi
         *    i mniej podatnymi na timeouty niż Selenium, które wymaga WebDriverWait.
         */
    }
}
