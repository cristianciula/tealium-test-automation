package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public final class SeleniumUtils{

    private static WebDriver driver;
    public static void setDriver(WebDriver driver) {
        SeleniumUtils.driver = driver;
    }

    //------------------------------------------------------------------------------------------------------------//

    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public static void navigateTo(String string) {
        driver.get(string);
    }
    public static void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }
    public static void click(By by) {
        driver.findElement(by).click();
    }
    public static void clear(By by) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(Keys.BACK_SPACE);
    }
    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    public static String getText(By by) {
        return driver.findElement(by).getText();
    }
    public static boolean isElementDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }
    public static boolean isElementSelected(By by) {
        return driver.findElement(by).isSelected();
    }
    public static boolean isElementEnabled(By by) {
        return driver.findElement(by).isEnabled();
    }
    public static void sendKeys(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }
    public static void hoverOverElement(By by) {
        Actions actions = new Actions(driver);
        scrollToElement(by);
        actions.moveToElement(driver.findElement(by));
        actions.build().perform();
    }
}
