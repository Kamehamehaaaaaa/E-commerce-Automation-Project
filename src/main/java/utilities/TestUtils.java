package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {
    private final WebDriver driver;
    private WebDriverWait wait;

    private final int TIMEOUT = 10;

    public TestUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getText(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void scrollAndClickElement(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void switchToNewWindow() {
        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
