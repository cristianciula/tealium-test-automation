package tests;

import constants.AccountDashboardConst;
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

    //____________________POSITIVE TESTS____________________//

    @Test (description = "User entering valid Email and valid Password CAN login.")
    public void validEmailValidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.logoutUser();
    }

    //____________________NEGATIVE TESTS____________________//

    @Test (description = "User entering invalid Email and valid Password CANNOT login.")
    public void invalidEmailValidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(invalidUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }

    @Test (description = "User entering valid Email and invalid Password CANNOT login.")
    public void validEmailInvalidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();


    }

    @Test (description = "User leaving the Email and Password fields empty CANNOT login.")
    public void emptyEmailEmptyPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.clickLoginButton();



        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }

    @Test (description = "User leaving the Email field empty and entering valid Password CANNOT login.")
    public void emptyEmailValidPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Email required error message is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User was not redirected to the Login page.");
        assertTrue(loginPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }

    @Test (description = "User entering valid Email and leaving the Password field empty CANNOT login.")
    public void validEmailEmptyPasswordLogin() {
        loginPage.clearCredentialsInputFields();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInputField();
        loginPage.clickLoginButton();

        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password input error message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Password required error message is not displayed.");
    }

    @Test (description = "Validation error message is displayed for invalid Email syntax.")
    public void invalidEmailSyntaxValidationErrorMessage() {

    }

    @Test (description = "Empty Email field validation message is displayed.")
    public void emptyEmailValidationErrorMessage() {


        assertTrue(loginPage.emailEmptyErrorMessageIsDisplayed(), "Email required error message is not displayed.");
    }

    @Test (description = "Empty Password field validation message is displayed")
    public void emptyPasswordValidationErrorMessage() {

        assertTrue(loginPage.passwordEmptyErrorIsDisplayed(), "Password required error message is not displayed.");
    }

    @Test (description = "Invalid Email validation error message is displayed as expected.")
    public void invalidEmailValidationErrorMessage() {

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }

    @Test (description = "Invalid Password validation error message is displayed as expected.")
    public void invalidPasswordValidationErrorMessage() {

        assertTrue(loginPage.credentialsInvalidErrorMessageIsDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }



}
