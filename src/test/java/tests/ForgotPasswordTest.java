package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void testForgotPasswordFormSubmission() {
        logStep("Open Forgot Password page");
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logStep("Fill in email and submit the form");
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailInput.sendKeys("test@example.com");

        WebElement submitButton = driver.findElement(By.id("form_submit"));
        submitButton.click();

        logStep("Verify result");
        // Po kliknięciu Submit serwer zwraca 500 Internal Server Error.
        // W efekcie element email znika z DOM, dlatego nie próbujemy już go szukać.
        // Zamiast tego szukamy nagłówka błędu.
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
        String text = header.getText();
        assertTrue(text.contains("Internal Server Error"),
                "Expected error message to be shown, but got: " + text);
    }
}
