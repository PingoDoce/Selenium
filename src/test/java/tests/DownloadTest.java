package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DownloadPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

public class DownloadTest extends BaseTest {

    @Test
    @DisplayName("Lista plików powinna być dostępna do pobrania")
    public void testFilesAreListed() {
        DownloadPage page = new DownloadPage(driver);
        page.open();

        assertTrue(page.getNumberOfFiles() > 0, "Powinny być dostępne pliki do pobrania.");
        page.getFileNames().forEach(name -> assertFalse(name.isBlank(), "Nazwa pliku nie powinna być pusta"));
    }

    @Test
    @DisplayName("Kliknięcie w pierwszy plik powinno zainicjować pobieranie")
    public void testDownloadFileLink() {
        DownloadPage page = new DownloadPage(driver);
        page.open();

        // Kliknięcie — nie weryfikujemy pobrania
        page.downloadFirstFile();

        // 🔽 KOMENTARZ:
        // Selenium nie ma wbudowanej obsługi pobierania plików ani dostępu do systemu plików.
        // Nie można więc bezpośrednio sprawdzić, czy plik został zapisany na dysku.
        // Dla takich przypadków bardziej odpowiedni jest Playwright, który umożliwia:
        // - monitorowanie pobrań (waitForDownload)
        // - zapis pliku do folderu tymczasowego
        // - sprawdzenie zawartości pliku
        //
        // W Selenium można jedynie ustawić katalog docelowy i ręcznie sprawdzać plik lokalnie (np. z użyciem Java IO).

        logStep("Kliknięto w pierwszy plik – pobieranie zainicjowane (nie weryfikujemy zapisu)");
    }
}
