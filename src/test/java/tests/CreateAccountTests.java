package tests;

import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");

    @Test (description = "Tests that user can create an account using valid data")
    public void createNewAccount() throws InterruptedException {
        driver.get(URL.CREATE_ACCOUNT);
        createAccountPage.fillMandatoryFields(validUser);
        createAccountPage.unselectRememberMeCheckbox();
        createAccountPage.clickRegisterButton();
        Thread.sleep(2000);
    }

    @Test (description = "Tests that user cannot create an account by leaving mandatory fields empty")
    public void emptyMandatoryFields() {

    }

    @Test (description = "Tests that user cannot create an account using an existing account details")
    public void duplicateAccount() {

    }
}
