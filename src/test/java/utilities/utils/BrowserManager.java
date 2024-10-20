package utilities.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserManager {

    private static WebDriver driver;

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }

    // Initialize WebDriver
    public static void startBrowser(BrowserType browserName) {
        switch (browserName) {

            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                        "--disable-search-engine-choice-screen" +
                                "--start-maximized"
                );
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }

    // Return the current WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call startBrowser() first.");
        }
        return driver;
    }

    // Close the browser and quit WebDriver
    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
