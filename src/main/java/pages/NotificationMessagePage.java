package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagePage {
    private final WebDriver driver;

    private final By clickHereLink = By.linkText("Click here");
    private final By notification = By.id("flash");

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    public String getNotificationText() {
        return driver.findElement(notification).getText().trim();
    }

    public boolean isNotificationVisible() {
        return driver.findElement(notification).isDisplayed();
    }
}
