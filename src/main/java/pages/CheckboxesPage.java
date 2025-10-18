package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final By checkboxLocator = By.cssSelector("#checkboxes input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz wszystkie checkboxy")
    public List<WebElement> getAllCheckboxes() {
        return driver.findElements(checkboxLocator);
    }

    @Step("Sprawdź, czy checkbox o indeksie {index} jest zaznaczony")
    public boolean isCheckboxSelected(int index) {
        return getAllCheckboxes().get(index).isSelected();
    }

    @Step("Zaznacz checkbox o indeksie {index}")
    public void checkCheckbox(int index) {
        WebElement checkbox = getAllCheckboxes().get(index);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Step("Odznacz checkbox o indeksie {index}")
    public void uncheckCheckbox(int index) {
        WebElement checkbox = getAllCheckboxes().get(index);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
