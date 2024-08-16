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
    public void createAccount() {

        signUpPage.fillCreateAccountForm(user);
        signUpPage.clickRegister();
        //wait.waitUrlToBe(ACCOUNT_DASHBOARD_AFTER_REGISTRATION, 2);

        assertEquals(accountDashboardPage.getRegistrationSuccessfulMessage(), AccountDashboardConst.SUCCESSFUL_REGISTRATION_MESSAGE);
        assertEquals(accountDashboardPage.getUserGreetingPlaceholder(), AccountDashboardConst.HELLO_USERNAME_MESSAGE);

        header.clickAccountDropdownButton();
        assertTrue(header.isLogOutButtonDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

        signUpPage.clearCreateAccountForm();
        signUpPage.clickRegister();

        //Check the input fields validation error messages
        assertTrue(signUpPage.areEmptyFieldErrorsDisplayed());
        for (String inputError : signUpPage.getEmptyInputErrorMessages()) {
            assertEquals(inputError, SignUpConst.MANDATORY_FIELD_ERROR);
        }

        header.clickAccountDropdownButton();

        assertTrue(header.isLoginButtonDisplayed());
    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() throws InterruptedException {

        //STEPS
        signUpPage.fillCreateAccountForm(user);
        signUpPage.clickRegister();
        Thread.sleep(7000);
        header.clickAccountDropdownButton();
        header.selectLogoutDropdownOption();

        signUpPage.navigateToCreateAccountPage();
        signUpPage.fillCreateAccountForm(user);
        signUpPage.clickRegister();

        Thread.sleep(3000);
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
        signUpPage.clearEmailField();
        signUpPage.enterEmail(email);
        signUpPage.clickRegister();

        assertEquals(driver.getCurrentUrl(), URL.SIGN_UP_PAGE);
    }

}
