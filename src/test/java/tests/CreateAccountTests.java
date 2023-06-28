package tests;

import constants.AccountDashboardConst;
import constants.CreateAccountConst;
import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;
import static org.testng.Assert.*;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");

    @Test (description = "Tests that user can create an account using valid data and that is logged in upon doing so")
    public void createNewAccount() {

        driver.get(URL.CREATE_ACCOUNT_PAGE);
        createAccountPage.fillMandatoryFields(validUser);
        createAccountPage.unselectRememberMeCheckbox();
        createAccountPage.clickRegisterButton();

        assertEquals(AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE, accountDashboardPage.getRegistrationSuccessfulMessage());
        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.clickAccountButton();
        assertTrue(header.logOutButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

        driver.get(URL.CREATE_ACCOUNT_PAGE);
        createAccountPage.clearForm();
        createAccountPage.clickRegisterButton();

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
