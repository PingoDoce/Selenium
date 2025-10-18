package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeDomPage {
    private final WebDriver driver;

    public LargeDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get("https://the-internet.herokuapp.com/large");
    }

    public WebElement getTableCell(int row, int col) {
        String cellId = String.format("sibling-%d.%d", row, col);
        return driver.findElement(By.id(cellId));
    }

    public int countAllTableCells() {
        return driver.findElements(By.xpath("//table//td")).size();
    }
}
