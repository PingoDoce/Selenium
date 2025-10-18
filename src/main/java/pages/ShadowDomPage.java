package pages;

import org.openqa.selenium.WebDriver;

public class ShadowDomPage {
    private WebDriver driver;

    public ShadowDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/shadowdom");
    }
}
