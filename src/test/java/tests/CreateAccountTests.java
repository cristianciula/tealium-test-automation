package tests;

import constants.AccountDashboardConst;
import constants.CreateAccountConst;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");

    @Test (description = "Tests that user can create an account using valid data and that is logged in upon doing so")
    public void createNewAccount() {

        driver.get(URL.CREATE_ACCOUNT_PAGE);
        createAccountPage.fillMandatoryFields(validUser);
        createAccountPage.unselectRememberMeCheckbox();
        createAccountPage.clickRegisterButton();

        Assert.assertEquals(AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE, accountDashboardPage.getRegistrationSuccessfulMsg());
        Assert.assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getHelloUsernameMessage());

        header.clickAccountButton();
        Assert.assertTrue(header.logOutButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

        driver.get(URL.CREATE_ACCOUNT_PAGE);
        createAccountPage.clearForm();
        createAccountPage.clickRegisterButton();

        Assert.assertTrue(createAccountPage.inputFieldErrorsAreDisplayed());
        for (String inputError : createAccountPage.getInputFieldErrors()) {
            Assert.assertEquals(inputError, CreateAccountConst.MANDATORY_FIELD_ERROR);
        }
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

    }

    @Test (description = "Tests that user cannot create an account using a password that is less than 7 characters in length")
    public void invalidPasswordLength() {

    }
}
