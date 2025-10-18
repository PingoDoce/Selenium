package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StatusCodesPage;
import utils.BaseTest;

@Epic("The Internet")
@Feature("StatusCodes")
@Story("StatusCodes page test")
@Severity(SeverityLevel.NORMAL)
public class StatusCodesTest extends BaseTest {

    @Test
    @Description("Fail - nieobsługiwane")
    public void test() {
        Assertions.fail("Nieobsługiwane przez Selenium");
        /*
        W Selenium nie jest możliwe bezpośrednie sprawdzenie kodu statusu HTTP,
        ponieważ Selenium operuje na interfejsie użytkownika (UI) w przeglądarce, a nie na poziomie sieciowym.
         */
    }
}
