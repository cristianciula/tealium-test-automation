package tests;

import constants.AccountDashboardConst;
import constants.SignUpConst;
import testdata.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class SignUpTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.get(URL.SIGN_UP_PAGE);
    }

    @Test (description = "Tests that a user can create a new account")
    public void canCreateAccount() {

        signUpPage.fillCreateAccountForm(user);
        signUpPage.clickRegisterButton();

        assertEquals(accountDashboardPage.getRegistrationSuccessfulMessage(), AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE);
        assertEquals(accountDashboardPage.getWelcomeMessage(), AccountDashboardConst.HELLO_USERNAME_MESSAGE);

        header.clickAccountDropdownButton();
        assertTrue(header.isLogoutButtonDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void cannotCreateAccountWithEmptyMandatoryFields() {

        signUpPage.clearCreateAccountForm();
        signUpPage.clickRegisterButton();

        //Check the input fields validation error messages
        assertTrue(signUpPage.areEmptyFieldErrorsDisplayed());
        for (String inputError : signUpPage.getEmptyMandatoryInputsErrors()) {
            assertEquals(inputError, SignUpConst.MANDATORY_FIELD_ERROR);
        }

        header.clickAccountDropdownButton();

        assertTrue(header.isLoginButtonDisplayed());
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

        //STEPS
        signUpPage.fillCreateAccountForm(user);
        signUpPage.clickRegisterButton();

        header.clickAccountDropdownButton();
        header.clickLogoutDropdownOption();

        signUpPage.navigateToCreateAccountPage();
        signUpPage.fillCreateAccountForm(user);
        signUpPage.clickRegisterButton();
        signUpPage.isDuplicateAccountErrorDisplayed();

        //ASSERTIONS
        header.clickAccountDropdownButton();
        assertTrue(header.isLoginButtonDisplayed());


        //TODO - Add Assertions
        // Assert that validation error for user already exists is displayed
        // Assert that a new account has not been created and that user has not been logged in

    }

    @Test (description = "Tests that user cannot create an account using a password that is less than 7 characters in length")
    public void invalidPasswordLength() {
        //TODO - Add steps and assertions
    }

    @Test (description = "Tests that invalid email syntaxes are not accepted", dataProvider = "invalidEmailSyntax",
            dataProviderClass = DataProviders.class)
    public void invalidEmailSyntax(String email) {

        signUpPage.fillCreateAccountForm(user);
        signUpPage.clearEmailInput();
        signUpPage.enterEmail(email);
        signUpPage.clickRegisterButton();

        assertEquals(driver.getCurrentUrl(), URL.SIGN_UP_PAGE);
    }

}
