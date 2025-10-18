package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.KeyPressesPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyPressesTest {
    private WebDriver driver;
    private KeyPressesPage keyPressesPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        keyPressesPage = new KeyPressesPage(driver);
        keyPressesPage.open();
    }

    @Test
    public void testKeyPressA() {
        keyPressesPage.typeKey("A");
        String result = keyPressesPage.getResult();
        assertTrue(result.contains("A"), "Expected result to contain 'A'");
    }

    @Test
    public void testKeyPressEscape() {
        keyPressesPage.typeKey(Keys.ESCAPE);
        String result = keyPressesPage.getResult();
        assertTrue(result.contains("ESCAPE"), "Expected result to contain 'ESCAPE'");
    }

    @Test
    public void testKeyPressShift() {
        keyPressesPage.typeKey(Keys.SHIFT);
        String result = keyPressesPage.getResult();
        assertTrue(result.contains("SHIFT"), "Expected result to contain 'SHIFT'");
    }

    @Test
    public void testKeyPressAlt() {
        keyPressesPage.typeKey(Keys.ALT);
        String result = keyPressesPage.getResult();
        assertTrue(result.contains("ALT"), "Expected result to contain 'ALT'");
    }

    @Test
    public void testKeyPressTab() {
        keyPressesPage.typeKey(Keys.TAB);
        String result = keyPressesPage.getResult();
        assertTrue(result.contains("TAB"), "Expected result to contain 'TAB'");
    }

    @Test
    public void testKeyPressSpace() {
        keyPressesPage.typeKey(Keys.SPACE);
        String result = keyPressesPage.getResult();
        assertTrue(result.contains("SPACE"), "Expected result to contain 'SPACE'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
