package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage {
    private WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    public String getTextFromMiddleFrame() {
        // Przejście do top frame, a potem do middle
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String text = driver.findElement(By.id("content")).getText();
        driver.switchTo().defaultContent(); // Resetowanie
        return text;
    }

    public void openIFramePage() {
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    public String getTextFromIFrame() {
        driver.switchTo().frame("mce_0_ifr");
        String text = driver.findElement(By.id("tinymce")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void setTextInIFrame(String newText) {
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));

        // Kliknięcie wewnątrz edytora, zaznaczenie istniejącego tekstu i nadpisanie go
        editor.click();
        editor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        editor.sendKeys(newText);

        driver.switchTo().defaultContent();
    }
}
