package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MultipleWindowsPage {
    private final WebDriver driver;
    private final By clickHereLink = By.linkText("Click Here");
    private final By header = By.tagName("h3");

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}
