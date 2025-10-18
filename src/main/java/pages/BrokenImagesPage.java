package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage {
    private final WebDriver driver;
    private final By imageElements = By.tagName("img");

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz wszystkie obrazki z DOM")
    public List<WebElement> getAllImages() {
        return driver.findElements(imageElements);
    }

    @Step("Sprawdź obrazki, które mają naturalWidth == 0 (niewidoczne)")
    public List<WebElement> getBrokenImagesByNaturalWidth() {
        List<WebElement> broken = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement img : getAllImages()) {
            Long width = (Long) js.executeScript("return arguments[0].naturalWidth", img);
            if (width == 0) {
                broken.add(img);
            }
        }
        return broken;
    }
}
