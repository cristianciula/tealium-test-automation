package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    private static int LONG_WAIT = 10;
    private static int MEDIUM_WAIT = 5;
    private static int SHORT_WAIT = 1;

    public static void waitElementToBeVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitElementToBeSelected(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }
}
