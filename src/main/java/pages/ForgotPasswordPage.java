package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private final By emailInput = By.id("email");
    private final By retrieveButton = By.id("form_submit");
    private final By confirmationMessage = By.tagName("h1");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://the-internet.herokuapp.com/forgot_password");
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickRetrievePassword() {
        driver.findElement(retrieveButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
