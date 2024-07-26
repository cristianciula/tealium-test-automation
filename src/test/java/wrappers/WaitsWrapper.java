package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitsWrapper {

    private final WebDriver driver;
    
    public WaitsWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitElementToBeVisible(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitElementToBeClickable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitElementToBeSelected(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }
    public void waitUrlToBe(String expectedUrl, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    public void waitTextToBe(int waitInSeconds, By locator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementValue(locator, expectedText));
    }
    //TODO: Create custom waiter method to wait for a specific exact "string" if the value of that webelement is updated later than the element itself is displayed. Can potentially also add wait time as well.
    // Method can contain following parameters: (expectedText, waitTimeInSeconds)
}
