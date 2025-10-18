package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadPage {
    private WebDriver driver;
    private final String url = "https://the-internet.herokuapp.com/upload";

    private final By chooseFileInput = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadedFilesText = By.id("uploaded-files");

    public UploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void uploadFile(String fileName) {
        // Poprawiona ścieżka do pliku, uwzględniająca folder 'src'
        Path filePath = Paths.get("src/test/java/resources/", fileName);
        driver.findElement(chooseFileInput).sendKeys(filePath.toAbsolutePath().toString());
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(uploadedFilesText).getText();
    }
}
