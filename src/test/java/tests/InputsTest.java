package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InputsPage;
import utils.BaseTest;

public class InputsTest extends BaseTest {

    @Test
    public void testNumberInputField() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        InputsPage page = new InputsPage(driver);

        page.setInputValue("1234");
        Assertions.assertEquals("1234", page.getInputValue());

        page.setInputValue("-567");
        Assertions.assertEquals("-567", page.getInputValue());
    }

    @Test
    public void testInvalidInputIgnored() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        InputsPage page = new InputsPage(driver);

        page.setInputValue("abc");
        String value = page.getInputValue();

        // W większości przeglądarek input[type=number] zignoruje "abc" i pozostanie pusty
        Assertions.assertTrue(value.isEmpty(), "Expected field to remain empty on invalid input");
    }
}
