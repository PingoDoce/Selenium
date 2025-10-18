package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage {
    private final WebDriver driver;

    private final By columnA = By.id("column-a");
    private final By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Pobierz kolumnę A")
    public WebElement getColumnA() {
        return driver.findElement(columnA);
    }

    @Step("Pobierz kolumnę B")
    public WebElement getColumnB() {
        return driver.findElement(columnB);
    }

    @Step("Wykonaj drag & drop z A na B")
    public void dragAtoB() {
        WebElement source = getColumnA();
        WebElement target = getColumnB();

        String jsDnd = """
            function simulateDragDrop(sourceNode, destinationNode) {
                var EVENT_TYPES = {
                    DRAG_END: 'dragend',
                    DRAG_START: 'dragstart',
                    DROP: 'drop'
                }

                function createCustomEvent(type) {
                    var event = new CustomEvent("CustomEvent")
                    event.initCustomEvent(type, true, true, null)
                    event.dataTransfer = {
                        data: {},
                        setData: function (key, value) {
                            this.data[key] = value
                        },
                        getData: function (key) {
                            return this.data[key]
                        }
                    }
                    return event
                }

                function dispatchEvent(node, type, event) {
                    if (node.dispatchEvent) {
                        return node.dispatchEvent(event)
                    }
                    if (node.fireEvent) {
                        return node.fireEvent("on" + type, event)
                    }
                }

                var dragStartEvent = createCustomEvent(EVENT_TYPES.DRAG_START)
                dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, dragStartEvent)

                var dropEvent = createCustomEvent(EVENT_TYPES.DROP)
                dropEvent.dataTransfer = dragStartEvent.dataTransfer
                dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent)

                var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END)
                dragEndEvent.dataTransfer = dragStartEvent.dataTransfer
                dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent)
            }

            simulateDragDrop(arguments[0], arguments[1])
        """;

        ((JavascriptExecutor) driver).executeScript(jsDnd, source, target);
    }

    @Step("Pobierz nagłówek z kolumny A")
    public String getHeaderOfColumnA() {
        return getColumnA().findElement(By.tagName("header")).getText().trim();
    }

    @Step("Pobierz nagłówek z kolumny B")
    public String getHeaderOfColumnB() {
        return getColumnB().findElement(By.tagName("header")).getText().trim();
    }
}
