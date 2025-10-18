package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;

public class ChallengingDomPage {
    private final WebDriver driver;

    private final By headerButtons = By.cssSelector(".button");
    private final By tableHeaders = By.cssSelector("table thead tr th");
    private final By tableRows = By.cssSelector("table tbody tr");

    public ChallengingDomPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz wszystkie przyciski u góry strony")
    public List<WebElement> getHeaderButtons() {
        return driver.findElements(headerButtons);
    }

    @Step("Kliknij przycisk o indeksie {index}")
    public void clickHeaderButton(int index) {
        getHeaderButtons().get(index).click();
    }

    @Step("Pobierz wszystkie nagłówki tabeli")
    public List<WebElement> getTableHeaders() {
        return driver.findElements(tableHeaders);
    }

    @Step("Pobierz wszystkie wiersze tabeli")
    public List<WebElement> getTableRows() {
        return driver.findElements(tableRows);
    }

    @Step("Pobierz komórkę z wiersza {row} i kolumny {col}")
    public String getCellText(int row, int col) {
        return getTableRows().get(row).findElements(By.tagName("td")).get(col).getText();
    }

    @Step("Pobierz przyciski Edit z każdego wiersza")
    public List<WebElement> getEditButtons() {
        return driver.findElements(By.cssSelector("table tbody tr td a[href*='edit']"));
    }

    @Step("Pobierz przyciski Delete z każdego wiersza")
    public List<WebElement> getDeleteButtons() {
        return driver.findElements(By.cssSelector("table tbody tr td a[href*='delete']"));
    }
}
