package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import testdata.URL;
import testdata.User;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;


    @BeforeClass
    protected static void setUp() {

    }

    @AfterClass
    protected static void tearDown() {

    }

    @BeforeTest
    protected void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL.HOME_PAGE);
    }

    @AfterTest
    protected void afterEach() {
        driver.quit();
    }
}
