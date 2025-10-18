package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortableDataTablesPage {

    private WebDriver driver;

    // Konstruktor
    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metoda do pobierania komórki z tabeli na podstawie wiersza i kolumny
    public String getTableCellText(int row, int col) {
        // Lokator do tabeli
        WebElement table = driver.findElement(By.id("table1"));

        // Znalezienie wiersza i komórki w tabeli
        WebElement cell = table.findElement(By.xpath(".//tr[" + row + "]/td[" + col + "]"));

        // Zwrócenie tekstu komórki
        return cell.getText();
    }

    // Metoda do kliknięcia w link w tabeli na podstawie wiersza i kolumny
    public void clickLinkInTable(int row, int col) {
        // Lokator do tabeli
        WebElement table = driver.findElement(By.id("table1"));

        // Znalezienie linku w danej komórce
        WebElement link = table.findElement(By.xpath(".//tr[" + row + "]/td[" + col + "]/a"));

        // Kliknięcie w link
        link.click();
    }

    // Metoda do kliknięcia w nagłówek tabeli, aby posortować dane
    public void clickColumnHeaderToSort(int col) {
        // Kliknięcie w nagłówek kolumny
        WebElement columnHeader = driver.findElement(By.xpath("//th[" + col + "]"));
        columnHeader.click();
    }

    // Metoda do pobrania tekstu z nagłówka tabeli
    public String getTableHeaderText(int col) {
        WebElement columnHeader = driver.findElement(By.xpath("//th[" + col + "]"));
        return columnHeader.getText();
    }
}
