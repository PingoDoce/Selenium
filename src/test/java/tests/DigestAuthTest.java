package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.DigestAuthPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.fail;

@Epic("UI Tests")
@Feature("Digest Authentication Page")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DigestAuthTest extends BaseTest {

    private DigestAuthPage page;

    @Test
    @Story("Digest Auth – ograniczenie Selenium")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
        Test został oznaczony jako wyłączony, ponieważ Selenium nie wspiera Digest Authentication.

        W przeciwieństwie do Basic Auth, Digest Auth wymaga dodatkowej komunikacji na poziomie HTTP.
        Selenium nie udostępnia API do podania danych logowania dla takiego typu uwierzytelniania.

        Playwright rozwiązuje ten problem dzięki możliwości przekazania httpCredentials podczas tworzenia kontekstu przeglądarki.
    """)
    public void testDigestAuth() {
        fail("Selenium nie wspiera uwierzytelnienia typu Digest");
        /*
         * ➤ Digest Authentication NIE MOŻE być przetestowane przy pomocy Selenium.
         * ➤ Selenium nie wspiera uwierzytelnienia typu Digest (w przeciwieństwie do Playwright).
         *
         * 🔒 Po wejściu na stronę https://the-internet.herokuapp.com/digest_auth
         * przeglądarka wyświetla alert systemowy, który Selenium nie jest w stanie przechwycić.
         *
         * ✔ Playwright pozwala na testowanie Digest Auth dzięki httpCredentials:
         *
         * // Przykład Playwright (TypeScript):
         * const context = await browser.newContext({
         *   httpCredentials: {
         *     username: 'admin',
         *     password: 'admin'
         *   }
         * });
         * const page = await context.newPage();
         * await page.goto('https://the-internet.herokuapp.com/digest_auth');
         */
    }
}
