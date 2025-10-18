package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HoversPage;
import utils.BaseTest;

public class HoversTest extends BaseTest {

    @Test
    public void testHoverDisplaysCaption() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        HoversPage hoversPage = new HoversPage(driver);

        int userIndex = 1;
        hoversPage.hoverOverFigure(userIndex);

        String captionText = hoversPage.getCaptionText(userIndex);
        Assertions.assertTrue(captionText.contains("user" + (userIndex + 1)), "Caption should contain correct username");
    }
}
