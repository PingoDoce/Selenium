package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeolocationPage {

    private WebDriver driver;

    private By buttonLocator = By.tagName("button");
    private By latLocator = By.id("lat-value");
    private By lonLocator = By.id("long-value");

    public GeolocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWhereAmI() {
        driver.findElement(buttonLocator).click();
    }

    public String getLatitude() {
        return driver.findElement(latLocator).getText();
    }

    public String getLongitude() {
        return driver.findElement(lonLocator).getText();
    }
}
