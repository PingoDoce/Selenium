package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private final WebDriver driver;
    private final By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wykonaj kliknięcie prawym przyciskiem myszy na pole")
    public void rightClickHotSpot() {
        WebElement element = driver.findElement(hotSpot);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    @Step("Pobierz tekst z alertu")
    public String getAlertTextAndAccept() {
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }
}
