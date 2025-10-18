package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FloatingMenuPage {
    private WebDriver driver;
    private final String url = "https://the-internet.herokuapp.com/floating_menu";
    private final By menuLinks = By.cssSelector("#menu a");

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public List<WebElement> getMenuLinks() {
        return driver.findElements(menuLinks);
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isMenuVisible() {
        return driver.findElement(By.id("menu")).isDisplayed();
    }
}
