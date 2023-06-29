package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static void waitForElementToBeVisible(WebDriver driver, int maxWaitInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
