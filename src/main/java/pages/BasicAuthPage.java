package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage {
    private final WebDriver driver;

    private final By successMessage = By.cssSelector("p");

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz komunikat po zalogowaniu")
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
