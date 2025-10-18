package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class DownloadPage {
    private final WebDriver driver;
    private final By fileLinks = By.cssSelector(".example a");

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/download");
    }

    public List<String> getFileNames() {
        return driver.findElements(fileLinks).stream()
                .map(el -> el.getText())
                .toList();
    }

    public void downloadFirstFile() {
        driver.findElements(fileLinks).get(0).click();
    }

    public int getNumberOfFiles() {
        return driver.findElements(fileLinks).size();
    }
}
