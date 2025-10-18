package pages;

import org.openqa.selenium.WebDriver;

public class SecureFileDownloadPage {
    private WebDriver driver;

    public SecureFileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/download_securedownload");
    }
}
