package tests;

import constants.AccountDashboardConst;
import testdata.dataprovider.productDataProvider;
import testdata.dataprovider.userDataProvider;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;
import wrappers.SeleniumWrapper;

import java.time.Duration;

import static org.testng.Assert.*;

public class PlaygroundTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test (description = "User entering valid Email and valid Password CAN login.",
            dataProvider = "validCredentials", dataProviderClass = userDataProvider.class)
    public void validCredentialsLogin(String email, String password) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.logoutUser();
    }

    @Test (description = "User entering invalid credentials CANNOT login.",
            dataProvider = "invalidCredentials", dataProviderClass = userDataProvider.class)
    public void invalidCredentialsLogin(String email, String password) throws InterruptedException {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        //TODO - Find a way to properly assert if an invalid credentials user has actually logged in or not.
        // Getting false positives is very easy here because of assertions moving too fast, before the page is updated.
        // Asserting errors won't work for every scenario, because there are different errors and in some cases none.
        // Can't use Sleep because it slows down everything else pointlessly.
        // Checking that a page does NOT have a certain URL is pointless as well, because it will still pass each time, because
        // of assertions moving too fast...


        //Possible solution - although it slows down everything, just like Thread.sleep()

        //2nd option would be to carefully select and split dataProvider methods (Equivalance Partitioning) in order to provide
        //more concise scenarios
        if (loginPage.getCurrentUrl().equalsIgnoreCase(URL.LOGIN_PAGE)) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            try {
                wait.until(ExpectedConditions.urlToBe(URL.ACCOUNT_DASHBOARD_PAGE));
            } catch (TimeoutException timeoutException) {
                System.out.println("User is not on the Acount Dashboard page");
                assertEquals(SeleniumWrapper.getCurrentUrl(), URL.LOGIN_PAGE);
            }
            assertEquals(SeleniumWrapper.getCurrentUrl(), URL.LOGIN_PAGE);
        } else {
            loginPage.getCurrentUrl().equalsIgnoreCase(URL.ACCOUNT_DASHBOARD_PAGE);
            assertEquals(SeleniumWrapper.getCurrentUrl(), URL.LOGIN_PAGE);
            }
        }
    @Test (description = "example",
            dataProvider = "invalidEmailWithValidPassword", dataProviderClass = userDataProvider.class)
    public void exampleTest(String invalidEmail, String validPassword) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(validPassword);

        if(invalidEmail.isEmpty() || invalidEmail.equalsIgnoreCase(" ")) {
            assertEquals("blabla", "blabla");
            System.out.println(invalidEmail);
        }
        System.out.println(invalidEmail);
    }

}





