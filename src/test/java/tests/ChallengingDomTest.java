package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pages.ChallengingDomPage;
import utils.BaseTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Tests")
@Feature("Challenging DOM Page")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChallengingDomTest extends BaseTest {

    private ChallengingDomPage page;

    @BeforeEach
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        page = new ChallengingDomPage(driver);
        logStep("Otwórz stronę Challenging DOM");
    }

    @Test
    @Order(1)
    @Story("Struktura tabeli")
    @Description("Sprawdza, czy tabela zawiera poprawną liczbę kolumn i co najmniej jeden wiersz")
    public void testTableStructure() {
        List<WebElement> headers = page.getTableHeaders();
        List<WebElement> rows = page.getTableRows();

        assertEquals(7, headers.size(), "Tabela powinna mieć 7 kolumn");
        assertTrue(rows.size() > 0, "Tabela powinna mieć co najmniej jeden wiersz");
    }

    @Test
    @Order(2)
    @Story("Dane w komórce tabeli")
    @Description("Sprawdza, czy komórka [0][0] zawiera dane")
    public void testFirstCellHasText() {
        String text = page.getCellText(0, 0);
        assertNotNull(text);
        assertFalse(text.isEmpty(), "Komórka nie powinna być pusta");
    }

    @Test
    @Order(3)
    @Story("Kliknięcie przycisków u góry")
    @Description("Kliknij wszystkie trzy przyciski u góry strony")
    public void testHeaderButtonsClickable() {
        List<WebElement> buttons = page.getHeaderButtons();
        assertEquals(3, buttons.size(), "Powinny być 3 przyciski");

        for (int i = 0; i < 3; i++) {
            page.clickHeaderButton(i);
        }
    }
}
