package tests;

import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");

    @Test (description = "Tests that user can create a new account using valid data")
    public void createNewAccount() throws InterruptedException {
        driver.get(URL.CREATE_ACCOUNT);
        createAccountPage.fillMandatoryCreateAccountForm(validUser);
        if(createAccountPage.rememberMeCheckboxIsSelected()) {
            createAccountPage.clickRememberMeCheckbox();
        }
        createAccountPage.clickRegisterButton();
        Thread.sleep(3000);
    }

    @Test (description = "Tests that user cannot create a new account having empty mandatory fields", priority = 2, enabled = false)
    public void emptyMandatoryFields() {

    }
}
