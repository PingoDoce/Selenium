package pages;

import org.openqa.selenium.WebDriver;

public class AbTestingPage {
    private WebDriver driver;

    public AbTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/abtest");
    }
}
