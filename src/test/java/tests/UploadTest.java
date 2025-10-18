package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.UploadPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadTest extends BaseTest {

    @Test
    @DisplayName("Powinno się udać przesłać plik i wyświetlić jego nazwę")
    public void testFileUpload() {
        UploadPage page = new UploadPage(driver);
        page.open();

        String fileName = "testfile.txt";
        page.uploadFile(fileName);

        assertEquals(fileName, page.getUploadedFileName(),
                "Nazwa przesłanego pliku powinna być widoczna na stronie.");
    }
}
