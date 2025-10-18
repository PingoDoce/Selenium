package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HorizontalSliderPage;
import utils.BaseTest;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void testSliderValueChange() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        HorizontalSliderPage sliderPage = new HorizontalSliderPage(driver);

        String targetValue = "3.5";
        sliderPage.setSliderTo(targetValue);

        Assertions.assertEquals(targetValue, sliderPage.getSliderValue(), "Slider value should be 3.5");
    }
}
