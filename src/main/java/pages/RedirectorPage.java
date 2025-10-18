package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedirectorPage {
    private final WebDriver driver;
    private final By hereLink = By.linkText("here");

    public RedirectorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Kliknij link 'here'")
    public void clickHereLink() {
        driver.findElement(hereLink).click();
    }

    @Step("Pobierz aktualny URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
