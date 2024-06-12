package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import testdata.UserDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;
import static wrappers.SeleniumWrapper.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "Can login with valid Email and valid Password.",
            dataProvider = "validEmailValidPassword", dataProviderClass = UserDataProvider.class)
    public void canLoginWithValidEmailAndValidPassword(String email, String password) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertEquals(accountDashboardPage.getUserGreetingPlaceholder(), AccountDashboardConst.HELLO_USERNAME_MESSAGE, "Unexpected user greeting message.");
        assertTrue(accountDashboardPage.isPageTitleDisplayed(), "Page title is not displayed.");

        header.logoutUser();
    }

    @Test(description = "Cannot login with invalid Email and invalid Password.",
            dataProvider = "invalidEmailInvalidPassword", dataProviderClass = UserDataProvider.class)
    public void cannotLoginWithInvalidEmailAndInvalidPassword(String email, String password) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "Cannot login with valid Email and invalid Password.",
        dataProvider = "validEmailInvalidPassword", dataProviderClass = UserDataProvider.class)
    public void cannotLoginWithValidEmailAndInvalidPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }

    @Test(description = "Cannot login with invalid Email and valid Password.",
        dataProvider = "invalidEmailValidPassword", dataProviderClass = UserDataProvider.class)
    public void cannotLoginWithInvalidEmailAndValidPassword(String invalidEmail, String validPassword) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
        assertEquals(getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
    }


    @Test(description = "User leaving the Email and Password fields empty CANNOT login.")
    public void cannotLoginWithEmptyCredentials() {
        loginPage.clearCredentialsInputs();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Test(description = "User leaving the Email field empty and entering valid Password CANNOT login.")
    public void loginWithEmptyEmailAndValidPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_MESSAGE, "Email required message is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "Unexpected current URL.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Test(description = "User entering valid Email and leaving the Password field empty CANNOT login.")
    public void loginWithValidEmailAndEmptyPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password required message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_MESSAGE, "Unexpected password required message.");
    }

    @Test(description = "Validation error message is displayed for invalid Email syntax.",
            dataProvider = "invalidEmailSyntax", dataProviderClass = UserDataProvider.class)
    public void loginWithInvalidEmailSyntaxAndValidPassword(String invalidEmailSyntax) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(invalidEmailSyntax);
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        //TODO Add test assertions
    }

    @Test(description = "Empty Email field validation message is displayed.")
    public void verifyEmptyEmailErrorMessageIsDisplayed() {

        //TODO Add test steps

        assertTrue(loginPage.isEmailEmptyErrorMessageDisplayed(), "Email required message is not displayed.");
    }

    @Test(description = "Empty Password field validation message is displayed")
    public void verifyEmptyPasswordErrorMessageIsDisplayed() {

        //TODO Add test steps

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password required message is not displayed.");
    }

    @Test(description = "Invalid Email validation error message is displayed as expected.")
    public void verifyInvalidEmailErrorMessageIsDisplayed() {

        //TODO Add test steps

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
    }

    @Test(description = "Invalid Password validation error message is displayed as expected.")
    public void verifyInvalidPasswordErrorMessageIsDisplayed() {

        //TODO Add test steps

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_MESSAGE, "Unexpected invalid credentials message.");
    }
}
