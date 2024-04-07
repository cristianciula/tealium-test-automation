package tests;

import constants.AccountDashboardConst;
import dataprovider.dataProviders;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;
import wrappers.SeleniumWrapper;

import java.time.Duration;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test (description = "User entering valid Email and valid Password CAN login.",
            dataProvider = "validCredentials", dataProviderClass = dataProviders.class)
    public void validCredentialsLogin(String email, String password) {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.logoutUser();
    }

    @Test (description = "User entering invalid credentials CANNOT login.",
            dataProvider = "invalidCredentials", dataProviderClass = dataProviders.class)
    public void invalidCredentialsLogin(String email, String password) throws InterruptedException {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        //TODO - Find a way to properly assert if an invalid credentials user has actually logged in or not.
        // Getting false positives is very easy here because of assertions moving too fast, before the page is updated.
        // Asserting errors won't work for every scenario, because there are different errors and in some cases none.
        // Can't use Sleep because it slows down everything else pointlessly.
        // Checking that a page does NOT have a certain URL is pointless as well, because it will still pass each time, because
        // of assertions moving too fast.


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

//        assertTrue(loginPage.emailFieldIsDisplayed(), "Email field is not displayed.");
//        assertTrue(loginPage.passwordFieldIsDisplayed(), "Password field is not displayed.");
//        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }

//    @Test (description = "User entering invalid Email and valid Password CANNOT login.")
//    public void invalidEmailValidPasswordLogin() {
//        loginPage.clearCredentialsInputFields();
//        loginPage.enterEmail(invalidUser.getEmail());
//        loginPage.enterPassword(validUser.getPassword());
//        loginPage.clickLoginButton();
//
//        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials message is not displayed.");
//        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
//    }
//
//    @Test (description = "User entering valid Email and invalid Password CANNOT login.")
//    public void validEmailInvalidPasswordLogin() {
//        loginPage.clearCredentialsInputFields();
//        loginPage.enterEmail(validUser.getEmail());
//        loginPage.enterPassword(invalidUser.getPassword());
//        loginPage.clickLoginButton();
//
//
//    }
//
//    @Test (description = "User leaving the Email and Password fields empty CANNOT login.")
//    public void emptyEmailEmptyPasswordLogin() {
//        loginPage.clearCredentialsInputFields();
//        loginPage.clickLoginButton();
//
//
//
//        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
//    }
//
//    @Test (description = "User leaving the Email field empty and entering valid Password CANNOT login.")
//    public void emptyEmailValidPasswordLogin() {
//        loginPage.clearCredentialsInputFields();
//        loginPage.enterPassword(validUser.getPassword());
//        loginPage.clickLoginButton();
//
//        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Email required error message is not displayed.");
//        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User was not redirected to the Login page.");
//        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
//    }
//
//    @Test (description = "User entering valid Email and leaving the Password field empty CANNOT login.")
//    public void validEmailEmptyPasswordLogin() {
//        loginPage.clearCredentialsInputFields();
//        loginPage.enterEmail(validUser.getEmail());
//        loginPage.clearPasswordInputField();
//        loginPage.clickLoginButton();
//
//        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password input error message is not displayed.");
//        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Password required error message is not displayed.");
//    }
//
//    @Test (description = "Validation error message is displayed for invalid Email syntax.",
//            dataProvider = "invalidEmailSyntaxData", dataProviderClass = dataProviders.class)
//    public void invalidEmailSyntaxValidationErrorMessage(String invalidEmailSyntax) {
//        //loginPage.clearCredentialsInputFields();
//        loginPage.enterEmail(invalidEmailSyntax);
//        //loginPage.enterPassword(validUser.getPassword());
//        loginPage.clickLoginButton();
//    }
//
//    @Test (description = "Empty Email field validation message is displayed.")
//    public void emptyEmailValidationErrorMessage() {
//
//
//        assertTrue(loginPage.emailEmptyErrorMessageIsDisplayed(), "Email required error message is not displayed.");
//    }
//
//    @Test (description = "Empty Password field validation message is displayed")
//    public void emptyPasswordValidationErrorMessage() {
//
//        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password required error message is not displayed.");
//    }
//
//    @Test (description = "Invalid Email validation error message is displayed as expected.")
//    public void invalidEmailValidationErrorMessage() {
//
//        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
//        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
//    }
//
//    @Test (description = "Invalid Password validation error message is displayed as expected.")
//    public void invalidPasswordValidationErrorMessage() {
//
//        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
//        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
//    }

