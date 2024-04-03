package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LogInTests extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();
        driver.get(URL.LOGIN_PAGE);
    }

    //____________________POSITIVE TESTS____________________//

    @Test (description = "Tests that a registered user can successfully login", priority = 1)
    public void validCredentialsLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail(validUser.getEmail());
        logInPage.enterPassword(validUser.getPassword());
        logInPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.logoutUser();
    }

    //____________________NEGATIVE TESTS____________________//

    @Test (description = "Tests that a registered user cannot login without entering the password", priority = 2)
    public void emptyPasswordLogin() {
        driver.get(URL.LOGIN_PAGE);
        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail(validUser.getEmail());
        logInPage.clearPasswordInputField();
        logInPage.clickLoginButton();

        assertTrue(logInPage.passwordRequiredErrorIsDisplayed(), "Password input error message is not displayed.");
        assertEquals(logInPage.getPasswordRequiredErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR);
    }

    @Test (description = "Tests that a non registered user cannot successfully login", priority = 3)
    public void emptyEmailLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterPassword(validUser.getPassword());
        logInPage.clickLoginButton();

        assertEquals(logInPage.getEmailRequiredErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR);
        assertEquals(logInPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(logInPage.loginButtonIsDisplayed());
    }

    @Test (description = "Tests that a registered user cannot login using a wrong password", priority = 4)
    public void invalidPasswordLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail(validUser.getEmail());
        logInPage.enterPassword(invalidUser.getPassword());
        logInPage.clickLoginButton();

        assertTrue(logInPage.credentialsInvalidErrorMessageIsDisplayed());
        assertEquals(logInPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR);
    }

    @Test (description = "Tests that a user leaving the credential fields empty cannot login", priority = 5)
    public void emptyCredentialsLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.clickLoginButton();

        assertTrue(logInPage.emailRequiredErrorMessageIsDisplayed(), "Email required error message is not displayed.");
        assertTrue(logInPage.passwordRequiredErrorIsDisplayed(), "Password required error message is not displayed.");
        assertTrue(logInPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }
}
