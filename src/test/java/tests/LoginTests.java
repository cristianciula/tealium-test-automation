package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.BeforeClass;
import testdata.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;
import wrappers.SeleniumWrapper;

import static constants.LoginConst.*;
import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();

        //Create new User
        driver.get(URL.SIGN_UP_PAGE);
        signUpPage.registerUser(user);
    }

    @BeforeMethod
    public void beforeMethod() {

        //Navigate to Login page
        driver.manage().deleteAllCookies();
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "Can login with valid Email and valid Password",
            dataProvider = "validEmailValidPassword", dataProviderClass = DataProviders.class)
    public void canLoginWithValidEmailAndValidPassword(String validEmail, String validPassword) {

        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertEquals(accountDashboardPage.getWelcomeMessage(), AccountDashboardConst.HELLO_USERNAME_MESSAGE, "Incorrect welcome message.");
        assertTrue(accountDashboardPage.isPageTitleDisplayed(), "Account Dashboard page title is not displayed.");
        assertTrue(accountDashboardPage.isAccountInformationSectionDisplayed(), "Account Information section is not displayed.");
        assertEquals(SeleniumWrapper.getCurrentUrl(), URL.ACCOUNT_DASHBOARD_PAGE, "User is not on the Account Dashboard page.");
    }

    @Test(description = "Cannot login with invalid Email and invalid Password",
            dataProvider = "invalidEmailInvalidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithInvalidEmailAndInvalidPassword(String invalidEmail, String invalidPassword) {

        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed(), "Invalid Credentials error message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidError(), LoginConst.INVALID_CREDENTIALS_ERROR, "Incorrect invalid Credentials error message.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with valid Email and invalid Password",
        dataProvider = "validEmailInvalidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithValidEmailAndInvalidPassword(String validEmail, String invalidPassword) {

        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed(), "Invalid Credentials error message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidError(), LoginConst.INVALID_CREDENTIALS_ERROR, "Incorrect invalid Credentials error message.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with invalid Email and valid Password",
        dataProvider = "invalidEmailValidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithInvalidEmailAndValidPassword(String invalidEmail, String validPassword) {

        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed(), "Invalid Credentials error message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidError(), LoginConst.INVALID_CREDENTIALS_ERROR, "Incorrect invalid Credentials error message.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with empty Credentials")
    public void cannotLoginWithEmptyCredentials() {

        loginPage.clickLoginButton();

        assertTrue(loginPage.isEmailEmptyErrorDisplayed(), "Empty Email field error message is not displayed.");
        assertEquals(loginPage.getEmailEmptyError(), REQUIRED_FIELD_ERROR, "Incorrect empty Email field error message.");
        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Empty Password field error message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyError(), REQUIRED_FIELD_ERROR, "Incorrect empty Password field error message.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with empty Email and valid Password",
        dataProvider = "validPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithEmptyEmailAndValidPassword(String validPassword) {

        loginPage.clearEmailInput();
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isEmailEmptyErrorDisplayed(), "Empty Email field error message is not displayed.");
        assertEquals(loginPage.getEmailEmptyError(), REQUIRED_FIELD_ERROR, "Incorrect empty Email field error message.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with valid Email and empty Password",
        dataProvider = "validEmail", dataProviderClass = DataProviders.class)
    public void cannotLoginWithValidEmailAndEmptyPassword(String validEmail) {

        loginPage.enterEmail(validEmail);
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Empty Password field error message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyError(), REQUIRED_FIELD_ERROR, "Incorrect empty Password field error message.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with invalid Email syntax and valid Password",
            dataProvider = "invalidEmailSyntaxValidPassword", dataProviderClass = DataProviders.class)
    public void cannotLoginWithInvalidEmailSyntaxAndValidPassword(String invalidEmailSyntax, String validPassword) {

        loginPage.enterEmail(invalidEmailSyntax);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Empty Email field validation message is displayed.")
    public void verifyEmptyEmailErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isEmailEmptyErrorDisplayed(), "Email required message is not displayed.");
    }

    @Test(description = "Empty Password field validation message is displayed")
    public void verifyEmptyPasswordErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password required message is not displayed.");
    }

    @Test(description = "Invalid Email validation error message is displayed as expected.")
    public void verifyInvalidEmailErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed(), "Invalid credentials message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidError(), LoginConst.INVALID_CREDENTIALS_ERROR, "Unexpected invalid credentials message.");
    }

    @Test(description = "Invalid Password validation error message is displayed as expected.")
    public void verifyInvalidPasswordErrorMessageIsDisplayed() {

        //TODO Add steps

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed(), "Invalid credentials message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidError(), LoginConst.INVALID_CREDENTIALS_ERROR, "Unexpected invalid credentials message.");
    }
}
