package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InfiniteScrollPage {
    private final WebDriver driver;
    private final JavascriptExecutor js;

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollDown() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public int countParagraphs() {
        List<WebElement> paragraphs = driver.findElements(org.openqa.selenium.By.className("jscroll-added"));
        return paragraphs.size();
    }
}
