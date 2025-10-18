package pages;

import org.openqa.selenium.WebDriver;

public class JavaScriptOnloadEventErrorPage {
    private final WebDriver driver;
    private final String url = "https://the-internet.herokuapp.com/javascript_error";

    public JavaScriptOnloadEventErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }
}
