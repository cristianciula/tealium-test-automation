package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public final class SeleniumWrapper {

    private static WebDriver driver;
    public static void setDriver(WebDriver driver) {
        SeleniumWrapper.driver = driver;
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(locator));
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public static void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void click(By locator) {
        scrollToElement(locator);
        driver.findElement(locator).click();
    }

    public static void clear(By locator) {
        scrollToElement(locator);
        driver.findElement(locator).clear();
    }

    public static String getText(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).getText();
    }

    public static boolean isElementDisplayed(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).isDisplayed();
    }

    public static boolean isElementSelected(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).isSelected();
    }

    public static boolean isElementEnabled(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).isEnabled();
    }

    public static void sendText(By locator, String text) {
        clear(locator);
        scrollToElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public static void hoverOver(By locator) {
        Actions actions = new Actions(driver);
        scrollToElement(locator);
        actions.moveToElement(driver.findElement(locator));
        actions.build().perform();
    }

    public static void dragAndDrop(By sourceLocator, By targetLocator) {
        Actions actions = new Actions(driver);
        scrollToElement(sourceLocator);
        actions.dragAndDrop((WebElement) sourceLocator, (WebElement) targetLocator);
        actions.build().perform();
    }

    public static String getAttribute(By locator, String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

//    public static boolean isElementInViewport(By locator) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//        boolean isElementVisible = js.executeScript("return (window.pageYOffset > document.querySelector(locator).getBoundingClientRect().bottom);");
//        return isElementVisible;
//    }

}
