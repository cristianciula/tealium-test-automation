package tests;

import constants.AccountDashboardConst;
import constants.RegistrationConst;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;
import static utils.TextUtils.*;

public class RegistrationTests extends BaseTest {

    @Test (description = "Tests that a user can create a new account")
    public void createAccount() {

        registrationPage.navigateToCreateAccountPage();
        registrationPage.fillCreateAccountForm(validUser);
        registrationPage.clickRegister();

        assertEquals(AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE, accountDashboardPage.getRegistrationSuccessfulMessage());
        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.clickAccountButton();
        assertTrue(header.logOutButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

        registrationPage.navigateToCreateAccountPage();
        registrationPage.clearCreateAccountForm();
        registrationPage.clickRegister();

        assertTrue(registrationPage.emptyFieldErrorsAreDisplayed());
        for (String inputError : registrationPage.getEmptyInputErrors()) {
            assertEquals(inputError, RegistrationConst.MANDATORY_FIELD_ERROR);
        }

        header.clickAccountButton();

        assertTrue(header.loginButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

        createAccount();
        header.clickLogoutButton();
        createAccount();
        registrationPage.navigateToCreateAccountPage();
        registrationPage.fillCreateAccountForm(validUser);
        registrationPage.clickRegister();

        //Assert that validation error for user already exists is displayed
        //Assert that a new account has not been created and that user has not been logged in

    }

    @Test (description = "Tests that user cannot create an account using a password that is less than 7 characters in length")
    public void invalidPasswordLength() {

    }

    @Test (description = "Tests that invalid email syntaxes are not accepted")
    public void invalidEmailSyntax() {
        driver.get(URL.CREATE_ACCOUNT_PAGE);
        registrationPage.fillCreateAccountForm(validUser);
        registrationPage.clearEmailField();

        String[] invalidEmails = stringToArray(invalidUser.getEmail());

        for (String invalidEmail : invalidEmails) {
            registrationPage.enterEmail(invalidEmail);
            registrationPage.clickRegister();
            assertEquals(driver.getCurrentUrl(), URL.CREATE_ACCOUNT_PAGE);
            registrationPage.clearEmailField();
        }
    }
}
