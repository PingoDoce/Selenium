package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InfiniteScrollPage;
import utils.BaseTest;

public class InfiniteScrollTest extends BaseTest {

    @Test
    public void testLoadMoreParagraphsOnScroll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        InfiniteScrollPage page = new InfiniteScrollPage(driver);

        int initialCount = page.countParagraphs();

        // Scrollujemy kilka razy
        for (int i = 0; i < 3; i++) {
            page.scrollDown();
            Thread.sleep(1500); // Czekamy na doładowanie treści
        }

        int finalCount = page.countParagraphs();
        Assertions.assertTrue(finalCount > initialCount, "Nowe paragrafy powinny się załadować po scrollu");
    }
}
