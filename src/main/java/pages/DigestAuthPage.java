package pages;

/*
 * DigestAuthPage – pusty Page Object, ponieważ Selenium nie może nawet załadować DOM tej strony.
 *
 * Digest Authentication odbywa się na poziomie HTTP, przed załadowaniem HTML.
 * Selenium NIE MA możliwości przesłania danych uwierzytelniających dla Digest Auth.
 *
 * W przypadku Playwright możesz ustawić dane przez:
 * browser.newContext({ httpCredentials: { username: 'admin', password: 'admin' } })
 */
public class DigestAuthPage {
    // Nie można zaimplementować żadnych akcji UI, ponieważ DOM nie jest dostępny.
}
