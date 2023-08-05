package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @Test (description = "Tests that a registered used can successfully login")
    public void validCredentialsLogin() {
        driver.get(URL.LOGIN_PAGE);
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.clickAccountButton();
        assertTrue(header.logOutButtonIsDisplayed());

        header.clickLogoutButton();
    }
    @Test (description = "Tests that a registered user cannot login using a wrong password")
    public void wrongPasswordLogin() {
        driver.get(URL.LOGIN_PAGE);
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.invalidCredentialsErrorIsDisplayed());
        assertEquals(loginPage.getInvalidCredentialsError(), LoginConst.INVALID_CREDENTIALS_ERROR);
    }
    @Test (description = "Tests that a registered user cannot login without entering the password")
    public void emptyPasswordLogin() {
        driver.get(URL.LOGIN_PAGE);
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.passwordInputErrorIsDisplayed());
        assertEquals(loginPage.getPasswordInputError(), LoginConst.REQUIRED_FIELD_ERROR);
    }
    @Test (description = "Tests that a non registered user cannot successfully login")
    public void nonRegisteredEmailLogin() {
        driver.get(URL.LOGIN_PAGE);
        loginPage.enterEmail(invalidUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getInvalidCredentialsError(), LoginConst.INVALID_CREDENTIALS_ERROR);
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
