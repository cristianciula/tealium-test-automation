package tests;

import pages.components.Header;
import pages.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import pages.AccountDashboardPage;
import testdata.User;
import utilities.helpers.SeleniumHelper;
import utilities.utils.BrowserManager;

import static utilities.utils.BrowserManager.BrowserType.CHROME;

public class BaseTest {

    public WebDriver driver;

    public static Header header;
    public static NavigationBar navigationBar;
    public static HomePage homePage;
    public static WomenPage womenPage;
    public static MenPage menPage;
    public static LoginPage loginPage;
    public static SignUpPage signUpPage;
    public static AccountDashboardPage accountDashboardPage;

    public static User user = new User();

    @BeforeClass
    public void beforeClass() {

        BrowserManager.startBrowser(CHROME);
        driver = BrowserManager.getDriver();

        SeleniumHelper.setDriver(driver);

        header = new Header(driver);
        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        womenPage = new WomenPage(driver);
        menPage = new MenPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);
    }

    @AfterClass
    public void afterClass() {

        driver.manage().deleteAllCookies();

        BrowserManager.quitBrowser();

        header = null;
        navigationBar = null;
        homePage = null;
        loginPage = null;
        signUpPage = null;
        womenPage = null;
        menPage = null;
        accountDashboardPage = null;
    }

}
