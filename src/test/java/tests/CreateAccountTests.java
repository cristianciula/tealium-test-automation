package tests;

import constants.AccountDashboardConst;
import constants.CreateAccountConst;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CreateAccountTests extends BaseTest {

    @Test (description = "Tests that a user can create a new account")
    public void createAccount() {

        createAccountPage.navigateToCreateAccountPage();
        createAccountPage.fillCreateAccountForm(validUser);
        createAccountPage.registerUser();

        assertEquals(AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE, accountDashboardPage.getRegistrationSuccessfulMessage());
        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.clickAccountButton();
        assertTrue(header.logOutButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

        createAccountPage.navigateToCreateAccountPage();
        createAccountPage.clearCreateAccountForm();
        createAccountPage.registerUser();

        assertTrue(createAccountPage.emptyFieldErrorsAreDisplayed());
        for (String inputError : createAccountPage.getEmptyFieldErrors()) {
            assertEquals(inputError, CreateAccountConst.MANDATORY_FIELD_ERROR);
        }

        header.clickAccountButton();

        assertTrue(header.loginButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {
        createAccount();
        header.logoutUser();
        createAccount();
        createAccountPage.navigateToCreateAccountPage();
        createAccountPage.fillCreateAccountForm(validUser);
        createAccountPage.registerUser();

        //Assert that validation error for user already exists is displayed
        //Assert that a new account has not been created and that user has not been logged in

    }

    @Test (description = "Tests that user cannot create an account using a password that is less than 7 characters in length")
    public void invalidPasswordLength() {

    }
}
