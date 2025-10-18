package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.JavaScriptAlertsPage;

import static org.junit.jupiter.api.Assertions.*;

public class JavaScriptAlertsTest {
    private WebDriver driver;
    private JavaScriptAlertsPage page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        page = new JavaScriptAlertsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void testJsAlertAccept() {
        page.triggerJsAlert();
        page.acceptAlert();
        assertEquals("You successfully clicked an alert", page.getResultText());
    }

    @Test
    public void testJsConfirmAccept() {
        page.triggerJsConfirm();
        page.acceptAlert();
        assertEquals("You clicked: Ok", page.getResultText());
    }

    @Test
    public void testJsConfirmDismiss() {
        page.triggerJsConfirm();
        page.dismissAlert();
        assertEquals("You clicked: Cancel", page.getResultText());
    }

    @Test
    public void testJsPromptInput() {
        String input = "Selenium Test";
        page.triggerJsPrompt();
        page.sendTextToPrompt(input);
        assertEquals("You entered: " + input, page.getResultText());
    }

    @Test
    public void testJsPromptCancel() {
        page.triggerJsPrompt();
        page.dismissAlert();
        assertEquals("You entered: null", page.getResultText());
    }
}
