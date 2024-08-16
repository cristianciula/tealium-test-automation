package tests;

import pages.components.Header;
import pages.components.MenuBar;
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

    public WebDriver driver;
    public WaitsWrapper wait;

    public static Header header;
    public static MenuBar menuBar;
    public static HomePage homePage;
    public static WomenPage womenPage;
    public static LoginPage loginPage;
    public static SignUpPage signUpPage;
    public static AccountDashboardPage accountDashboardPage;

    public static User user = new User();

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--start-maximized " +
                "--disable-search-engine-choice-screen"
        );

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        SeleniumWrapper.setDriver(driver);

        wait = new WaitsWrapper(driver);

        header = new Header(driver);
        menuBar = new MenuBar(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        womenPage = new WomenPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);

    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();

        if (driver != null) {
            driver.quit();
            driver = null;
        }

        header = null;
        menuBar = null;
        homePage = null;
        loginPage = null;
        signUpPage = null;
        womenPage = null;
        accountDashboardPage = null;

    }

}
