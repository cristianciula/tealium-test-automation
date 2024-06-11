package tests;

import constants.AccountDashboardConst;
import constants.SignUpConst;
import testdata.dataprovider.UserDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class SignUpTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.CREATE_ACCOUNT_PAGE);
    }

    @Test (description = "Tests that a user can create a new account")
    public void createAccount() {

        signUpPage.fillCreateAccountForm(validUser);
        signUpPage.clickRegister();

        assertEquals(AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE, accountDashboardPage.getRegistrationSuccessfulMessage());
        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.clickAccountDropdownButton();
        assertTrue(header.isLogOutButtonDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

        signUpPage.clearCreateAccountForm();
        signUpPage.clickRegister();

        assertTrue(signUpPage.areEmptyFieldErrorsDisplayed());
        for (String inputError : signUpPage.getEmptyInputErrorMessages()) {
            assertEquals(inputError, SignUpConst.MANDATORY_FIELD_ERROR);
        }

        header.clickAccountDropdownButton();

        assertTrue(header.isLoginButtonDisplayed());
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

        createAccount();
        header.selectLogoutDropdownOption();
        createAccount();
        signUpPage.navigateToCreateAccountPage();
        signUpPage.fillCreateAccountForm(validUser);
        signUpPage.clickRegister();

        //TODO - Add Assertions
        // Assert that validation error for user already exists is displayed
        // Assert that a new account has not been created and that user has not been logged in

    }


    @Test (description = "Tests that user cannot create an account using a password that is less than 7 characters in length")
    public void invalidPasswordLength() {
        //TODO - Add steps and assertions
    }

    @Test (description = "Tests that invalid email syntaxes are not accepted", dataProvider = "invalidCredentials",
            dataProviderClass = UserDataProvider.class)
    public void invalidEmailSyntax(String email) {

        signUpPage.fillCreateAccountForm(validUser);
        signUpPage.clearEmailField();
        signUpPage.enterEmail(email);
        signUpPage.clickRegister();

        assertEquals(driver.getCurrentUrl(), URL.CREATE_ACCOUNT_PAGE);


//        String[] invalidEmails = stringToArray(invalidUser.getEmail());

//        for (String invalidEmail : invalidEmails) {
//            signUpPage.enterEmail(invalidEmail);
//            signUpPage.clickRegister();
//            assertEquals(driver.getCurrentUrl(), URL.CREATE_ACCOUNT_PAGE);
//            signUpPage.clearEmailField();
//        }
    }
}
