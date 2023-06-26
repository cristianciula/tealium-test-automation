package tests;

import constants.AccountDashboardPageConst;
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

        Assert.assertEquals(AccountDashboardPageConst.SUCCESSFUL_REGISTRATION_MESSAGE, accountDashboardPage.getRegistrationSuccessfulMsg());
        Assert.assertEquals(AccountDashboardPageConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getHelloUsernameMessage());

        header.clickAccountButton();
        Assert.assertTrue(header.logOutButtonIsDisplayed());
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

    }
}
