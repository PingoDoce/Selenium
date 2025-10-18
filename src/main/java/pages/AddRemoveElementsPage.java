package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;

    private final By addElementButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.cssSelector("button.added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kliknij przycisk 'Add Element'")
    public void clickAddElement() {
        driver.findElement(addElementButton).click();
    }

    @Step("Kliknij przycisk 'Delete' o indeksie {index}")
    public void clickDeleteButton(int index) {
        List<WebElement> deletes = getDeleteButtons();
        if (index < deletes.size()) {
            deletes.get(index).click();
        }
    }

    @Step("Pobierz liczbę przycisków 'Delete'")
    public int getDeleteButtonsCount() {
        return getDeleteButtons().size();
    }

    private List<WebElement> getDeleteButtons() {
        return driver.findElements(deleteButtons);
    }
}
