package tests;

import components.Header;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import testdata.User;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    public static Header header;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static CreateAccountPage createAccountPage;
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        header = new Header(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
