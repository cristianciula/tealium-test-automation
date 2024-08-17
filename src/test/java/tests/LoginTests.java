package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import testdata.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;
import static wrappers.SeleniumWrapper.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();

        //Create new User
//        driver.get(URL.SIGN_UP_PAGE);
//        signUpPage.registerUser();
//        header.logoutUser();

        //Navigate to Login page
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "Can login with valid Email and valid Password.",
            dataProvider = "validEmailValidPassword", dataProviderClass = DataProviders.class)
    public void canLoginWithValidEmailAndValidPassword(String validEmail, String validPassword) {
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertEquals(accountDashboardPage.getUserGreetingPlaceholder(), AccountDashboardConst.HELLO_USERNAME_MESSAGE, "Unexpected user greeting message.");
        assertTrue(accountDashboardPage.isPageTitleDisplayed(), "Page title is not displayed.");

        header.logoutUser();
    }

    @Test(description = "Cannot login with invalid Email and invalid Password.",
            dataProvider = "invalidEmailInvalidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithInvalidEmailAndInvalidPassword(String invalidEmail, String invalidPassword) {
        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "Cannot login with valid Email and invalid Password.",
        dataProvider = "validEmailInvalidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithValidEmailAndInvalidPassword(String validEmail, String invalidPassword) {
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "Cannot login with invalid Email and valid Password.",
        dataProvider = "invalidEmailValidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithInvalidEmailAndValidPassword(String invalidEmail, String validPassword) {
        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "User leaving the Email and Password fields empty CANNOT login.")
    public void cannotLoginWithEmptyCredentials() {
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Test(description = "Cannot login with empty Email and valid Password.",
        dataProvider = "validPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithEmptyEmailAndValidPassword(String validPassword) {
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_MESSAGE, "Email required message is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "Cannot login with valid Email and empty Password.",
        dataProvider = "validEmail", dataProviderClass = DataProviders.class)
    public void cannotLoginWithValidEmailAndEmptyPassword(String validEmail) {
        loginPage.enterEmail(validEmail);
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password required message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_MESSAGE, "Unexpected password required message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "Validation error message is displayed for invalid Email syntax.",
            dataProvider = "invalidEmailSyntaxValidPassword", dataProviderClass = DataProviders.class)
    public void loginWithInvalidEmailSyntaxAndValidPassword(String invalidEmailSyntax, String validPassword) throws InterruptedException {
        loginPage.enterEmail(invalidEmailSyntax);
        System.out.println(invalidEmailSyntax);
        Thread.sleep(5000);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        //TODO Add assertions
    }

    @Test(description = "Empty Email field validation message is displayed.")
    public void verifyEmptyEmailErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isEmailEmptyErrorMessageDisplayed(), "Email required message is not displayed.");
    }

    @Test(description = "Empty Password field validation message is displayed")
    public void verifyEmptyPasswordErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password required message is not displayed.");
    }

    @Test(description = "Invalid Email validation error message is displayed as expected.")
    public void verifyInvalidEmailErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
    }

    @Test(description = "Invalid Password validation error message is displayed as expected.")
    public void verifyInvalidPasswordErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
    }
}
