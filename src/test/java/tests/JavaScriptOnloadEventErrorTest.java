package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.log.Log;

public class JavaScriptOnloadEventErrorTest {

    @Test
    public void testJavaScriptOnloadError() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("Log from browser: " + logEntry.getText());
        });

        driver.get("https://the-internet.herokuapp.com/javascript_error");

        // UWAGA:
        // W przeciwieństwie do Playwright, Selenium nie ma wbudowanego API do przechwytywania błędów JS (np. page.on('pageerror')).
        // Można próbować odczytać logi przez driver.manage().logs().get("browser"), ale nie jest to w pełni niezawodne i zależy od wersji przeglądarki.
        //
        // W efekcie test działa niestabilnie lub wcale – nie jest zalecany do produkcyjnego wykrywania JS runtime errorów.

        driver.quit();
        Assertions.fail("Selenium nie ma wbudowanego API do przechwytywania błędów JS");

    }
}
