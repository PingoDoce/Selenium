package tests;

import org.junit.jupiter.api.Test;
import pages.FramesPage;
import utils.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FramesTest extends BaseTest {

//    @Test
    public void testMiddleFrameContent() {
        logStep("Navigate to nested frames");
        FramesPage framesPage = new FramesPage(driver);
        framesPage.openNestedFrames();

        logStep("Get text from middle frame");
        String text = framesPage.getTextFromMiddleFrame();

        assertEquals("MIDDLE", text);
    }
}
