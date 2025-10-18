package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

public class JavaScriptAlertsPage {
    private WebDriver driver;

    private final By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private final By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private final By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private final By resultText = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerJsAlert() {
        driver.findElement(jsAlertButton).click();
    }

    public void triggerJsConfirm() {
        driver.findElement(jsConfirmButton).click();
    }

    public void triggerJsPrompt() {
        driver.findElement(jsPromptButton).click();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendTextToPrompt(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
}
