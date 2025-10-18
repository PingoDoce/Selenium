package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicContentPage {
    private final WebDriver driver;
    private final By contentBlocks = By.cssSelector("#content > .row");

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz wszystkie bloki dynamicznej treści")
    public List<WebElement> getAllContentBlocks() {
        return driver.findElements(contentBlocks);
    }

    @Step("Pobierz zawartość tekstową każdego bloku")
    public List<String> getAllTexts() {
        return getAllContentBlocks().stream()
                .map(block -> block.getText().trim())
                .toList();
    }
}
