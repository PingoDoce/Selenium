package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By startButton = By.cssSelector("#start button");
    private final By loading = By.id("loading");
    private final By result = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Kliknij Start")
    public void clickStart() {
        driver.findElement(startButton).click();
    }

    @Step("Poczekaj na zniknięcie wskaźnika ładowania")
    public void waitForLoadingToFinish() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
    }

    @Step("Pobierz wynikowy tekst")
    public String getResultText() {
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        return resultElement.getText().trim();
    }
}
