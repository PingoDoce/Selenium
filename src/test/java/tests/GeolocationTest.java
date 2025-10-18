package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.emulation.Emulation;
import pages.GeolocationPage;
import utils.BaseTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeolocationTest extends BaseTest {

    @Test
    public void testMockedGeolocation() {
        driver.get("https://the-internet.herokuapp.com/geolocation");

        // Ustaw mock geolokalizacji przez CDP (Chrome tylko)
        if (!(driver instanceof ChromeDriver chrome)) {
            throw new IllegalStateException("Ten test wymaga ChromeDrivera.");
        }
        DevTools devTools = chrome.getDevTools();
        devTools.createSession();

        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(50.06143),   // latitude
                Optional.of(19.93658),   // longitude
                Optional.of(100),        // accuracy
                Optional.empty(),        // altitude
                Optional.empty(),        // altitudeAccuracy
                Optional.empty(),        // heading
                Optional.empty()         // speed
        ));

        GeolocationPage page = new GeolocationPage(driver);
        page.clickWhereAmI();

//        wait.until(d -> !page.getLatitude().isEmpty() && !page.getLongitude().isEmpty());

        assertTrue(page.getLatitude().contains("50"));
        assertTrue(page.getLongitude().contains("19"));
    }
}
