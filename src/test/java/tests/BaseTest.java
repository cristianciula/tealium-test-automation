package tests;

import pages.components.Header;
import pages.components.MenuBar;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import pages.AccountDashboardPage;
import testdata.User;
import wrappers.SeleniumWrapper;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public static Header header;
    public static MenuBar menuBar;
    public static HomePage homePage;
    public static WomenPage womenPage;
    public static LoginPage loginPage;
    public static SignUpPage signUpPage;
    public static AccountDashboardPage accountDashboardPage;

    public static User user = new User();

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--no-first-run" +
                "--no-default-browser-check" +
                "--disable-search-engine-choice-screen" +
                "--start-maximized"
        );

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        SeleniumWrapper.setDriver(driver);

        header = new Header(driver);
        menuBar = new MenuBar(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        womenPage = new WomenPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);

    }

    @AfterClass
    public void afterClass() {
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
