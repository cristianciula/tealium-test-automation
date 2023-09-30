package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();

        driver.get(URL.LOGIN_PAGE);
    }

    @Test (description = "Tests that a user leaving the credential fields empty cannot login", priority = 1)
    public void emptyCredentialsLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.clickLoginButton();
    }
    @Test (description = "Tests that a registered used can successfully login")
    public void validCredentialsLogin() {
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.clickAccountButton();

        assertTrue(header.logOutButtonIsDisplayed());

        //OUTRO
        header.clickLogoutButton();
    }
    @Test (description = "Tests that a registered user cannot login using a wrong password", priority = 2)
    public void invalidPasswordLogin() {
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed());
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR);
    }
    @Test (description = "Tests that a registered user cannot login without entering the password", priority = 3)
    public void emptyPasswordLogin() {
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInputField();
        loginPage.clickLoginButton();

        assertTrue(loginPage.passwordInputErrorIsDisplayed());
        assertEquals(loginPage.getPasswordRequiredErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR);
    }
    @Test (description = "Tests that a non registered user cannot successfully login", priority = 4)
    public void nonRegisteredEmailLogin() {
        loginPage.enterEmail(invalidUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();
        
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR);
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
