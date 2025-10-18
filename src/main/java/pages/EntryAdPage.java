package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By modal = By.id("modal");
    private final By modalTitle = By.cssSelector(".modal-title");
    private final By closeModalButton = By.cssSelector(".modal-footer p");
    private final By clickHereLink = By.linkText("click here");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/entry_ad");
    }

    public void waitForModalToAppear() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        } catch (TimeoutException e) {
            System.out.println("Modal nie pojawił się w oczekiwanym czasie.");
        }
    }

    public void closeModal() {
        wait.until(ExpectedConditions.elementToBeClickable(closeModalButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
    }

    public boolean isModalVisible() {
        try {
            return driver.findElement(modal).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public String getModalTitle() {
        return driver.findElement(modalTitle).getText();
    }

    public void restartModal() {
        driver.findElement(clickHereLink).click();
        waitForModalToAppear();
    }
}
