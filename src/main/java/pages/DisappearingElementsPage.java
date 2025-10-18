package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisappearingElementsPage {
    private final WebDriver driver;

    private final By navLinks = By.cssSelector("ul li a");

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz wszystkie linki z menu")
    public List<WebElement> getNavigationLinks() {
        return driver.findElements(navLinks);
    }

    @Step("Sprawdź, czy istnieje link o nazwie: {linkText}")
    public boolean isLinkPresent(String linkText) {
        return getNavigationLinks()
                .stream()
                .anyMatch(e -> e.getText().trim().equalsIgnoreCase(linkText));
    }

    @Step("Kliknij link o nazwie: {linkText}")
    public void clickLink(String linkText) {
        for (WebElement link : getNavigationLinks()) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                return;
            }
        }
        throw new IllegalStateException("Nie znaleziono linku: " + linkText);
    }
}
