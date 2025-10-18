package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage {
    private final WebDriver driver;

    private final By inputField = By.id("target");
    private final By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
    }

    public void typeKey(CharSequence key) {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(key);
    }

    public String getResult() {
        return driver.findElement(resultText).getText();
    }
}
