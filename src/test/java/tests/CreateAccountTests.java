package tests;

import constants.AccountDashboardConst;
import constants.CreateAccountConst;
import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;
import static org.testng.Assert.*;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");

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

        driver.get(URL.CREATE_ACCOUNT_PAGE);
        createAccountPage.clearCreateAccountForm();
        createAccountPage.registerUser();

        assertTrue(createAccountPage.areFieldInputErrorsDisplayed());
        for (String inputError : createAccountPage.getFieldInputErrors()) {
            assertEquals(inputError, CreateAccountConst.MANDATORY_FIELD_ERROR);
        }
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

    }

    @Test (description = "Tests that user cannot create an account using a password that is less than 7 characters in length")
    public void invalidPasswordLength() {

    }
}
