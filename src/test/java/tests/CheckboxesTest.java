package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.CheckboxesPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Tests")
@Feature("Checkboxes Page")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckboxesTest extends BaseTest {

    private CheckboxesPage page;

    @BeforeEach
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        page = new CheckboxesPage(driver);
        logStep("Otwórz stronę Checkboxes");
    }

    @Test
    @Order(1)
    @Story("Domyślny stan checkboxów")
    @Description("Sprawdza, że pierwszy checkbox jest odznaczony, a drugi zaznaczony")
    public void testDefaultState() {
        assertFalse(page.isCheckboxSelected(0), "Checkbox 1 powinien być odznaczony");
        assertTrue(page.isCheckboxSelected(1), "Checkbox 2 powinien być zaznaczony");
    }

    @Test
    @Order(2)
    @Story("Zaznaczenie checkboxa")
    @Description("Zaznacz pierwszy checkbox i sprawdź stan")
    public void testCheckFirstCheckbox() {
        page.checkCheckbox(0);
        assertTrue(page.isCheckboxSelected(0), "Checkbox 1 powinien być zaznaczony");
    }

    @Test
    @Order(3)
    @Story("Odznaczenie checkboxa")
    @Description("Odznacz drugi checkbox i sprawdź stan")
    public void testUncheckSecondCheckbox() {
        page.uncheckCheckbox(1);
        assertFalse(page.isCheckboxSelected(1), "Checkbox 2 powinien być odznaczony");
    }

    @Test
    @Order(4)
    @Story("Zaznaczenie obu checkboxów")
    @Description("Zaznacz oba checkboxy i sprawdź ich stan")
    public void testCheckBothCheckboxes() {
        page.checkCheckbox(0);
        page.checkCheckbox(1);

        assertTrue(page.isCheckboxSelected(0), "Checkbox 1 powinien być zaznaczony");
        assertTrue(page.isCheckboxSelected(1), "Checkbox 2 powinien być zaznaczony");
    }

    @Test
    @Order(5)
    @Story("Odznaczenie obu checkboxów")
    @Description("Odznacz oba checkboxy i sprawdź ich stan")
    public void testUncheckBothCheckboxes() {
        page.uncheckCheckbox(0);
        page.uncheckCheckbox(1);

        assertFalse(page.isCheckboxSelected(0), "Checkbox 1 powinien być odznaczony");
        assertFalse(page.isCheckboxSelected(1), "Checkbox 2 powinien być odznaczony");
    }
}
