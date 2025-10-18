package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.LargeDomPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LargeDomTest extends BaseTest {

    @Test
    @Description("Sprawdza, czy wybrana komórka z dużego DOM istnieje i zawiera poprawną treść")
    public void testAccessSpecificTableCell() {
        LargeDomPage page = new LargeDomPage(driver);
        page.navigate();
        logStep("Przechodzimy do strony z dużym DOM");

        var cell = page.getTableCell(25, 3); // istniejąca komórka
        logStep("Pobieramy komórkę o ID: sibling-25.3");

        assertNotNull(cell);
        logStep("Komórka istnieje");

        assertEquals("25.3", cell.getText());
        logStep("Komórka zawiera oczekiwany tekst");
    }

    @Test
    @Description("Zlicza liczbę wszystkich komórek w tabeli — test orientacyjny do pomiarów wydajności Selenium vs Playwright")
    public void testCountAllTableCells() {
        LargeDomPage page = new LargeDomPage(driver);
        page.navigate();
        logStep("Przechodzimy do strony z dużym DOM");

        int cellCount = page.countAllTableCells();
        logStep("Zliczamy wszystkie komórki");

        assertEquals(2500, cellCount); // 50 × 50 komórek
        logStep("Weryfikujemy czy liczba komórek to 2500");
    }
}
