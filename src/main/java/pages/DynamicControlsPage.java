package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By checkbox = By.id("checkbox");
    private final By removeAddButton = By.xpath("//form[@id='checkbox-example']//button");
    private final By message = By.id("message");

    private final By inputField = By.xpath("//form[@id='input-example']/input");
    private final By enableDisableButton = By.xpath("//form[@id='input-example']//button");

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Kliknij przycisk Remove/Add")
    public void clickRemoveAddButton() {
        driver.findElement(removeAddButton).click();
    }

    @Step("Czekaj aż checkbox zniknie")
    public void waitForCheckboxToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
    }

    @Step("Czekaj aż checkbox się pojawi")
    public void waitForCheckboxToAppear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
    }

    @Step("Kliknij przycisk Enable/Disable")
    public void clickEnableDisableButton() {
        driver.findElement(enableDisableButton).click();
    }

    @Step("Czekaj aż input będzie aktywny")
    public void waitForInputToBeEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
    }

    @Step("Czekaj aż input będzie nieaktywny")
    public void waitForInputToBeDisabled() {
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(inputField)));
    }

    @Step("Sprawdź czy input jest aktywny")
    public boolean isInputEnabled() {
        return driver.findElement(inputField).isEnabled();
    }

    @Step("Sprawdź czy checkbox jest widoczny")
    public boolean isCheckboxVisible() {
        try {
            return driver.findElement(checkbox).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Pobierz wiadomość")
    public String getMessage() {
        return driver.findElement(message).getText();
    }
}
