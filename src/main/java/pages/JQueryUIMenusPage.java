package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryUIMenusPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String url = "https://the-internet.herokuapp.com/jqueryui/menu";


    private final By enabledItem = By.xpath("//li[@id='ui-id-3']/a");
    private final By downloadsItem = By.xpath("//li[@id='ui-id-4']/a");
    private final By pdfLink = By.xpath("//a[text()='PDF']");
    private final By csvLink = By.xpath("//a[text()='CSV']");
    private final By excelLink = By.xpath("//a[text()='Excel']");

    public JQueryUIMenusPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(url);
    }

    public void hoverToDownloads() {
        Actions actions = new Actions(driver);
        // Najeżdżamy na 'Enabled'
        WebElement enabled = wait.until(ExpectedConditions.visibilityOfElementLocated(enabledItem));
        actions.moveToElement(enabled).perform();

        // Najeżdżamy na 'Downloads'
        WebElement downloads = wait.until(ExpectedConditions.visibilityOfElementLocated(downloadsItem));
        actions.moveToElement(downloads).perform();

        // Czekamy, aż link do PDF będzie widoczny, co oznacza, że submenu się pojawiło
        wait.until(ExpectedConditions.visibilityOfElementLocated(pdfLink));
    }

    private WebElement getPdfElement() {
        return driver.findElement(pdfLink);
    }

    private WebElement getCsvElement() {
        return driver.findElement(csvLink);
    }

    private WebElement getExcelElement() {
        return driver.findElement(excelLink);
    }

    public String getPdfHref() {
        return getPdfElement().getAttribute("href");
    }

    public String getCsvHref() {
        return getCsvElement().getAttribute("href");
    }

    public String getExcelHref() {
        return getExcelElement().getAttribute("href");
    }

    public boolean isPdfVisible() {
        return getPdfElement().isDisplayed();
    }

    public boolean isCsvVisible() {
        return getCsvElement().isDisplayed();
    }

    public boolean isExcelVisible() {
        return getExcelElement().isDisplayed();
    }
}
