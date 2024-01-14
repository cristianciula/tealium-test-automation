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
import wrapers.SeleniumUtils;
import utils.WaitsUtils;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    public static Header header;
    public static MenuBar menuBar;
    public static HomePage homePage;
    public static LogInPage logInPage;
    public static SignUpPage signUpPage;
    public static AccountDashboardPage accountDashboardPage;
    public static MenProductsPage menProductsPage;
    public static MenShirtsPage menShirtsPage;
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
        options.addArguments("no-sandbox");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        header = new Header(driver);
        menuBar = new MenuBar(driver);
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        signUpPage = new SignUpPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);
        menProductsPage = new MenProductsPage(driver);
        menShirtsPage = new MenShirtsPage(driver);

        SeleniumUtils.setDriver(driver);
        WaitsUtils.setDriver(driver);
    }

    @AfterTest
    public void afterTest() {

        header.logoutUser();

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
