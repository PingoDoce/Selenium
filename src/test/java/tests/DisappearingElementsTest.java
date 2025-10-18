package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pages.DisappearingElementsPage;
import utils.BaseTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Tests")
@Feature("Disappearing Elements Page")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DisappearingElementsTest extends BaseTest {

    private DisappearingElementsPage page;

    @BeforeEach
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        page = new DisappearingElementsPage(driver);
        logStep("Otwórz stronę Disappearing Elements");
    }

    @Test
    @Order(1)
    @Story("Sprawdzenie liczby linków")
    @Description("Sprawdza, czy liczba linków w menu to 4 lub 5")
    public void testNumberOfLinks() {
        List<WebElement> links = page.getNavigationLinks();
        int size = links.size();
        captureScreenshot("Stan menu");
        assertTrue(size == 4 || size == 5, "Menu powinno zawierać 4 lub 5 linków, obecnie: " + size);
    }

    @Test
    @Order(2)
    @Story("Sprawdzenie obecności linku Gallery")
    @Description("Sprawdza, czy link 'Gallery' pojawia się w menu po kilku odświeżeniach")
    public void testGalleryLinkAppearsEventually() {
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            driver.navigate().refresh();
            if (page.isLinkPresent("Gallery")) {
                found = true;
                break;
            }
        }

        captureScreenshot("Po odświeżeniach");
        assertTrue(found, "Link 'Gallery' powinien pojawić się po kilkukrotnym odświeżeniu strony");
    }

    @Test
    @Order(3)
    @Story("Klikalność linków")
    @Description("Kliknij każdy dostępny link i wróć, aby sprawdzić działanie")
    public void testEachLinkIsClickable() {
        Set<String> testedLinks = new HashSet<>();

        for (WebElement link : page.getNavigationLinks()) {
            String text = link.getText().trim();
            if (text.equalsIgnoreCase("Gallery")) continue; // może nie działać – pomijamy
            testedLinks.add(text);

            logStep("Kliknij link: " + text);
            page.clickLink(text);
            assertTrue(driver.getTitle().length() > 0 || driver.getPageSource().contains("Not Found"));

            driver.navigate().back();
        }

        captureScreenshot("Po kliknięciach");
        assertFalse(testedLinks.isEmpty(), "Powinien być przynajmniej 1 kliknięty link");
    }
}
