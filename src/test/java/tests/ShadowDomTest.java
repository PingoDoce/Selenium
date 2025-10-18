package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ShadowDomPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.fail;

@Epic("The Internet")
@Feature("ShadowDom")
@Story("ShadowDom page test")
@Severity(SeverityLevel.NORMAL)
public class ShadowDomTest extends BaseTest {

    @Test
    @Description("Test failujący w Selenium")
    public void testOpenPage() {
        fail("Selenium nie obsługuje Shadow DOM");
    }
    /*
    Selenium nie obsługuje Shadow DOM wprost, ponieważ dla Selenium standardowe metody wyszukiwania elementów
    (takie jak findElement) nie działają bezpośrednio na elementach znajdujących się w Shadow DOM.
    Z tego powodu, aby przeprowadzić testy na elementach w Shadow DOM, musisz użyć specjalnych metod umożliwiających dostanie się do ukrytego drzewa DOM.

Z kolei w Playwright obsługuje Shadow DOM w sposób bardziej naturalny i bez konieczności używania specjalnych technik.
     */
}
