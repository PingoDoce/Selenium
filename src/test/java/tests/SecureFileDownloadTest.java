package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class SecureFileDownloadTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test failujący w Selenium")
    public void testSecureFileLinksFailing() {
        fail("test niemożliwy do zaimplementowania wyłącznie w selenium");
        /*test niemożliwy do zaimplementowania wyłącznie w selenium:

        Pobieranie plików zabezpieczonych nie jest bezpośrednio wspierane przez Selenium,
        ponieważ Selenium nie przechwytuje pobieranych plików z przeglądarki.
        Nie możemy więc asertywnie sprawdzić, czy plik został fizycznie pobrany bez:
        - przekonfigurowania profilu przeglądarki (np. ChromeOptions z niestandardowym folderem downloadów),
        - lub użycia biblioteki HTTP (np. HttpClient) z osobną sesją (z przekazanym ciasteczkiem logowania).
         */
    }
}
