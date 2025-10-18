package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.JQueryUIMenusPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JQueryUIMenusTest extends BaseTest {
    private JQueryUIMenusPage pageObject;

    @BeforeEach
    public void pageSetup() {
        // Driver jest inicjowany w BaseTest, tutaj tworzymy obiekt strony i otwieramy URL
        pageObject = new JQueryUIMenusPage(driver);
        pageObject.open();
    }

    @Test
    public void testPdfDownloadLink() {
        pageObject.hoverToDownloads();
        assertTrue(pageObject.isPdfVisible(), "PDF link should be visible");
        // Selenium zwraca pełny URL, więc sprawdzamy, czy kończy się on oczekiwaną ścieżką
        assertTrue(pageObject.getPdfHref().endsWith("/download/jqueryui/menu/menu.pdf"),
                "Link do PDF powinien mieć prawidłowy atrybut href");
    }

    @Test
    public void testCsvDownloadLink() {
        pageObject.hoverToDownloads();
        assertTrue(pageObject.isCsvVisible(), "CSV link should be visible");
        assertTrue(pageObject.getCsvHref().endsWith("/download/jqueryui/menu/menu.csv"),
                "Link do CSV powinien mieć prawidłowy atrybut href");
    }

    @Test
    public void testExcelDownloadLink() {
        pageObject.hoverToDownloads();
        assertTrue(pageObject.isExcelVisible(), "Excel link should be visible");
        assertTrue(pageObject.getExcelHref().endsWith("/download/jqueryui/menu/menu.xls"),
                "Link do Excela powinien mieć prawidłowy atrybut href");
    }
}
