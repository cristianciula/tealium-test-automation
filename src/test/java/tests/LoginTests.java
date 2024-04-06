package tests;

import constants.AccountDashboardConst;
import constants.HeaderConst;
import constants.LoginConst;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test (description = "User entering valid credentials CAN login")
    public void validCredentialsLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(header.getWelcomeMessage().equalsIgnoreCase(HeaderConst.HEADER_WELCOME_MESSAGE));
        assertEquals(accountDashboardPage.getUserGreetingPlaceholder(), AccountDashboardConst.HELLO_USERNAME_MESSAGE);

        header.logoutUser();
    }

    @Test (description = "User entering invalid Email and valid Password CANNOT login")
    public void invalidEmailValidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(invalidUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.emailFieldIsDisplayed(), "Expected Email field to be displayed on the Login page");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Expected Login button to be displayed on the Login page");
    }

    @Test (description = "User entering valid Email and invalid Password CANNOT login")
    public void validEmailInvalidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.emailFieldIsDisplayed(), "Expected Email field to be displayed on the Login page");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Expected Login button to be displayed on the Login page");
    }

    @Test (description = "User leaving the Email and Password fields empty CANNOT login")
    public void emptyEmailEmptyPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.clickLoginButton();

        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.emailFieldIsDisplayed(), "Expected Email field to be displayed on the Login page");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Expected Login button to be displayed on the Login page");
    }

    @Test (description = "User leaving the Email field empty and entering valid Password CANNOT login")
    public void emptyEmailValidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.emailFieldIsDisplayed(), "Expected Email field to be displayed on the Login page");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Expected Login button to be displayed on the Login page");
    }

    @Test (description = "User entering valid Email and leaving the Password field empty CANNOT login")
    public void validEmailEmptyPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(loginPage.emailFieldIsDisplayed(), "Expected Email field to be displayed on the Login page");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Expected Login button to be displayed on the Login page");
    }

    @Test (description = "Validation error message is displayed for invalid Email syntax")
    public void invalidEmailSyntaxValidationErrorMessage() {

    }

    @Test (description = "Empty Email field validation message is displayed")
    public void emptyEmailValidationErrorMessage() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.emailEmptyErrorMessageIsDisplayed(), "Email required error message is not displayed");
        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR);
    }

    @Test (description = "Empty Password field validation message is displayed")
    public void emptyPasswordValidationErrorMessage() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clickLoginButton();

        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password input error message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Password required error message is not displayed");
    }

    @Test (description = "Invalid Email validation error message is displayed as expected")
    public void invalidEmailValidationErrorMessage() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail("invalidEmail@example.com");
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong");
    }

    @Test (description = "Invalid Password validation error message is displayed as expected")
    public void invalidPasswordValidationErrorMessage() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong");
    }



}
