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

    public void waitElementToBeVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitElementToBeClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitElementToBeSelected(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void waitUrlToBe(String expectedUrl, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    public boolean waitTextToBePresentInElement(int waitInSeconds, By locator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
            return true;
        } catch (Exception e) {
            System.out.println("Text '" + expectedText + "' not found in the element located by: " + locator);
            return false;
        }
    }
    
}
