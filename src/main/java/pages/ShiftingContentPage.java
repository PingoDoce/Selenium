package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShiftingContentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String URL = "https://the-internet.herokuapp.com/shifting_content/menu";

    // Zaktualizowane lokatory, aby pasowały do przykładu Playwright
    private final By menuLocator = By.cssSelector("#content ul");
    // Selektor dla drugiego elementu listy (About)
    private final By firstMenuLinkLocator = By.cssSelector("#content ul li:nth-child(2) a");

    public ShiftingContentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(URL);
    }

    public void waitForMenu() {
        // Czekamy na widoczność całego menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
    }

    public void clickFirstMenuLink() {
        // Czekamy, aż link będzie klikalny i go klikamy
        wait.until(ExpectedConditions.elementToBeClickable(firstMenuLinkLocator)).click();
    }

    public boolean waitForUrlContains(String fragment) {
        // Czekamy, aż URL będzie zawierał oczekiwany fragment
        return wait.until(ExpectedConditions.urlContains(fragment));
    }
}
