package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {
    private final WebDriver driver;
    private final By figure = By.className("figure");
    private final By caption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverFigure(int index) {
        List<WebElement> figures = driver.findElements(figure);
        Actions actions = new Actions(driver);
        actions.moveToElement(figures.get(index)).perform();
    }

    public String getCaptionText(int index) {
        List<WebElement> captions = driver.findElements(caption);
        return captions.get(index).getText();
    }
}
