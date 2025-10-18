package pages;

import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
    private WebDriver driver;

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }
}
