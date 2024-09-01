package tests;

import constants.AccountDashboardConst;
import org.testng.annotations.BeforeClass;
import testdata.DataProviders.UserDataProviders;
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

        header.logoutUser();
    }

    @BeforeMethod
    public void beforeMethod() {

        //Navigate to Login page
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "Can login with valid credentials",
            dataProvider = "validEmailValidPassword", dataProviderClass = UserDataProviders.class)
    public void canLoginWithValidEmailAndValidPassword(String validEmail, String validPassword) {

        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertEquals(accountDashboardPage.getWelcomeMessage(), AccountDashboardConst.HELLO_USERNAME_MESSAGE, "Incorrect welcome message.");
        assertTrue(accountDashboardPage.isPageTitleDisplayed(), "Account Dashboard page title is not displayed.");
        assertTrue(accountDashboardPage.isAccountInformationSectionDisplayed(), "Account Information section is not displayed.");
        assertEquals(SeleniumWrapper.getCurrentUrl(), URL.ACCOUNT_DASHBOARD_PAGE, "User is not on the Account Dashboard page.");

        header.logoutUser();
    }

    @Test(description = "Cannot login with valid Email and invalid Password",
            dataProvider = "validEmailInvalidPassword", dataProviderClass = UserDataProviders.class)
    public void cannotLoginWithValidEmailAndInvalidPassword(String validEmail, String invalidPassword) {

        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }

    @Test(description = "Cannot login with invalid Email and valid Password",
            dataProvider = "invalidEmailValidPassword", dataProviderClass = UserDataProviders.class)
    public void cannotLoginWithInvalidEmailAndValidPassword(String invalidEmail, String validPassword) {

        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User is not on the Login page.");
    }


    /* -------------------- VALIDATION ERROR MESSAGES TESTS -------------------- */

    @Test(description = "Empty Email validation error message is displayed as expected",
            dataProvider = "validPassword", dataProviderClass = UserDataProviders.class)
    public void verifyEmptyEmailValidationErrorIsDisplayed(String validPassword) {

        loginPage.clearEmailInput();
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isEmailEmptyErrorDisplayed());
        assertEquals(loginPage.getEmailEmptyError(), MANDATORY_FIELD_ERROR);
    }

    @Test(description = "Empty Password validation error message is displayed as expected",
        dataProvider = "validEmail", dataProviderClass = UserDataProviders.class)
    public void verifyEmptyPasswordValidationErrorIsDisplayed(String validEmail) {

        loginPage.enterEmail(validEmail);
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed());
        assertEquals(loginPage.getPasswordEmptyError(), MANDATORY_FIELD_ERROR);
    }

    @Test(description = "Empty Credentials validation error messages are displayed as expected")
    public void verifyEmptyCredentialsValidationErrorsAreDisplayed() {

        loginPage.clearEmailInput();
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isEmailEmptyErrorDisplayed());
        assertEquals(loginPage.getEmailEmptyError(), MANDATORY_FIELD_ERROR);
        assertTrue(loginPage.isPasswordEmptyErrorDisplayed());
        assertEquals(loginPage.getPasswordEmptyError(), MANDATORY_FIELD_ERROR);
    }

    @Test(description = "Empty Credentials validation error messages are displayed as expected",
        dataProvider = "wrongEmailValidPassword", dataProviderClass = UserDataProviders.class)
    public void verifyWrongEmailValidationErrorIsDisplayed(String invalidEmail, String validPassword) {

        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
        assertEquals(loginPage.getCredentialsInvalidError(), INVALID_CREDENTIALS_ERROR);
    }

    @Test(description = "Empty Credentials validation error messages are displayed as expected",
            dataProvider = "validEmailWrongPassword", dataProviderClass = UserDataProviders.class)
    public void verifyWrongPasswordValidationErrorIsDisplayed(String validEmail, String invalidPassword) {

        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
        assertEquals(loginPage.getCredentialsInvalidError(), INVALID_CREDENTIALS_ERROR);
    }

    //TODO: Not all invalid email syntaxes are validated by browser. Refactor
    @Test(description = "Invalid Email syntax validation error message is displayed as expected",
            dataProvider = "invalidEmailSyntax", dataProviderClass = UserDataProviders.class)
    public void verifyInvalidEmailSyntaxValidationErrorIsDisplayed(String invalidEmailSyntax, String expectedMessage) {

        loginPage.enterEmail(invalidEmailSyntax);
        loginPage.clickLoginButton();

        assertEquals(loginPage.getEmailSyntaxValidationError(), expectedMessage);
    }

}
