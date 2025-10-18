package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SortableDataTablesPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortableDataTablesTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Selenium: Sprawdzanie sortowania tabeli po kliknięciu w nagłówek kolumny")
    public void testTableSorting() {
        // Uruchomienie przeglądarki
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        // Tworzenie instancji klasy Page
        SortableDataTablesPage page = new SortableDataTablesPage(driver);

        // Kliknięcie w nagłówek 1. kolumny (np. imię)
        page.clickColumnHeaderToSort(1);

        // Pobranie pierwszego wiersza w tabeli po sortowaniu
        String firstCellTextAfterSort = page.getTableCellText(1, 1);

        // Sprawdzenie, czy tekst w komórce zaczyna się od "B" - Bach
        // (Zakładamy, że dane są posortowane alfabetycznie rosnąco)
        assertTrue(firstCellTextAfterSort.startsWith("B"));

        // Kliknięcie w nagłówek 1. kolumny ponownie, aby posortować malejąco
        page.clickColumnHeaderToSort(1);

        // Pobranie pierwszego wiersza w tabeli po ponownym sortowaniu
        String firstCellTextAfterReverseSort = page.getTableCellText(1, 1);

        // Sprawdzenie, czy tekst w komórce zaczyna się od "S" - Smith
        // (Zakładamy, że dane są posortowane alfabetycznie malejąco)
        assertTrue(firstCellTextAfterReverseSort.startsWith("S"));

        // Zamknięcie przeglądarki
        driver.quit();
    }
}
