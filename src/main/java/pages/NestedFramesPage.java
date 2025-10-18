package pages;

import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/Nestedframes");
    }
}
