package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wybierz opcję po widocznym tekście: {optionText}")
    public void selectByVisibleText(String optionText) {
        new Select(driver.findElement(dropdown)).selectByVisibleText(optionText);
    }

    @Step("Pobierz aktualnie wybraną opcję")
    public String getSelectedOptionText() {
        return new Select(driver.findElement(dropdown)).getFirstSelectedOption().getText();
    }
}
