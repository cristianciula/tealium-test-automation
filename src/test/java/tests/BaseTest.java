package tests;

import components.Header;
import components.MenuBar;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import testdata.User;
import wrappers.SeleniumWrapper;
import wrappers.WaitsWrapper;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    public static Header header;
    public static MenuBar menuBar;
    public static HomePage homePage;
    public static LogInPage logInPage;
    public static SignUpPage signUpPage;
    public static AccountDashboardPage accountDashboardPage;
    public static User validUser = new User("validUser");
    public static User invalidUser = new User("invalidUser");

    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() {
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("no-sandbox");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        header = new Header(driver);
        menuBar = new MenuBar(driver);
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);

        SeleniumWrapper.setDriver(driver);
    }

    @AfterTest
    public void afterTest() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
