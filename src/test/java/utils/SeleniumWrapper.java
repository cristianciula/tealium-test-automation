package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public final class SeleniumWrapper {

    public static void scrollToElement(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void clickElement(WebDriver driver, By by) {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    public static boolean elementIsDisplayed(WebDriver driver, By by) {
        return driver.findElement(by).isDisplayed();
    }
    public static boolean elementIsSelected(WebDriver driver, By by) {
        return driver.findElement(by).isSelected();
    }
    public static boolean elementIsEnabled(WebDriver driver, By by) {
        return driver.findElement(by).isEnabled();
    }
    public static void sendKeys(WebDriver driver, By by, String string) {
        driver.findElement(by).sendKeys(string);
    }
}
