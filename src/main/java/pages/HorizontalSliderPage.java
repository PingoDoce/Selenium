package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private final WebDriver driver;
    private final By slider = By.tagName("input");
    private final By value = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSliderTo(String targetValue) {
        WebElement sliderElement = driver.findElement(slider);
        double currentValue = Double.parseDouble(driver.findElement(value).getText());
        double target = Double.parseDouble(targetValue);

        while (currentValue < target) {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
            currentValue = Double.parseDouble(driver.findElement(value).getText());
        }

        while (currentValue > target) {
            sliderElement.sendKeys(Keys.ARROW_LEFT);
            currentValue = Double.parseDouble(driver.findElement(value).getText());
        }
    }

    public String getSliderValue() {
        return driver.findElement(value).getText();
    }
}
