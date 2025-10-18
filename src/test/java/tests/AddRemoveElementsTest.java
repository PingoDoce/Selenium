package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.AddRemoveElementsPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI Tests")
@Feature("Add/Remove Elements Page")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddRemoveElementsTest extends BaseTest {

    private AddRemoveElementsPage page;

    @BeforeEach
    public void navigateToPage() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        logStep("Przejdź do strony Add/Remove Elements");
        page = new AddRemoveElementsPage(driver);
    }

    @Test
    @Order(1)
    @Story("Add single element")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sprawdzenie, czy jedno kliknięcie przycisku 'Add Element' dodaje jeden przycisk 'Delete'")
    public void testAddOneElement() {
        logStep("Kliknij 'Add Element'");
        page.clickAddElement();

        logStep("Sprawdź liczbę przycisków 'Delete'");
        int count = page.getDeleteButtonsCount();

        assertEquals(1, count, "Powinien być jeden przycisk 'Delete'");
    }

    @Test
    @Order(2)
    @Story("Add multiple elements")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sprawdzenie dodawania wielu przycisków 'Delete'")
    public void testAddMultipleElements() {
        int clicks = 5;
        logStep("Kliknij 'Add Element' " + clicks + " razy");
        for (int i = 0; i < clicks; i++) {
            page.clickAddElement();
        }

        logStep("Sprawdź liczbę przycisków 'Delete'");
        int count = page.getDeleteButtonsCount();

        assertEquals(clicks, count, "Powinno być " + clicks + " przycisków 'Delete'");
    }

    @Test
    @Order(3)
    @Story("Delete one element")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sprawdzenie, czy usunięcie elementu działa prawidłowo")
    public void testDeleteElement() {
        logStep("Dodaj 3 przyciski 'Delete'");
        for (int i = 0; i < 3; i++) {
            page.clickAddElement();
        }

        logStep("Usuń drugi przycisk 'Delete'");
        page.clickDeleteButton(1);

        logStep("Sprawdź liczbę pozostałych przycisków");
        int count = page.getDeleteButtonsCount();

        assertEquals(2, count, "Powinny zostać 2 przyciski 'Delete'");
    }
}
