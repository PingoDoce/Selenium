package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage {
    private final WebDriver driver;
    private final By inputField = By.tagName("input");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputValue(String value) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(value);
    }

    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
