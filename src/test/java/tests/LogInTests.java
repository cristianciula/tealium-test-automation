package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LogInTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    //____________________POSITIVE TESTS____________________//

    @Test (description = "Tests that a user entering valid credentials can login", priority = 1)
    public void validEmailAndPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.logoutUser();
    }

    //____________________NEGATIVE TESTS____________________//

    @Test (description = "Tests that a user leaving the Email field empty cannot login.", priority = 2)
    public void emptyEmailLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Email required error message is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User was not redirected to the Login page.");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }

    @Test (description = "Tests that a user leaving the Password field empty cannot login.", priority = 3)
    public void emptyPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInputField();
        loginPage.clickLoginButton();

        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password input error message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Password required error message is not displayed.");
    }

    @Test (description = "Tests that a user leaving the Email and Password fields empty cannot login", priority = 4)
    public void emptyEmailAndPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.clickLoginButton();

        assertTrue(loginPage.emailEmptyErrorMessageIsDisplayed(), "Email required error message is not displayed.");
        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password required error message is not displayed.");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }

    @Test (description = "Tests that a user entering an invalid Email and a valid Password cannot login.", priority = 5)
    public void invalidEmailLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail("invalidEmail@test.com");
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }

    @Test (description = "Tests that a user entering a valid Email and an invalid Password cannot login.", priority = 6)
    public void invalidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }
}
