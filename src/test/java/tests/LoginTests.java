package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;
import static utils.SeleniumUtils.*;

public class LoginTests extends BaseTest {

    @Test (description = "Tests that a registered used can successfully login", priority = 1)
    public void validCredentialsLogin() {
        navigateTo(URL.LOGIN_PAGE);
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
    public void wrongPasswordLogin() {
        navigateTo(URL.LOGIN_PAGE);
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.invalidCredentialsErrorIsDisplayed());
        assertEquals(loginPage.getInvalidCredentialsError(), LoginConst.INVALID_CREDENTIALS_ERROR);
    }
    @Test (description = "Tests that a registered user cannot login without entering the password", priority = 3)
    public void emptyPasswordLogin() {
        navigateTo(URL.LOGIN_PAGE);
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.passwordInputErrorIsDisplayed());
        assertEquals(loginPage.getPasswordInputError(), LoginConst.REQUIRED_FIELD_ERROR);
    }
    @Test (description = "Tests that a non registered user cannot successfully login", priority = 4)
    public void nonRegisteredEmailLogin() {
        navigateTo(URL.LOGIN_PAGE);
        loginPage.enterEmail(invalidUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();
        
        assertEquals(loginPage.getInvalidCredentialsError(), LoginConst.INVALID_CREDENTIALS_ERROR);
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
