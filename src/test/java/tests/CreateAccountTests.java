package tests;

import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");

    @Test(description = "Tests that user can create a new account using valid data")
    public void createNewAccount() throws InterruptedException {
        driver.get(URL.HOME_PAGE);
        header.clickAccountButton();
        header.clickMyAccountButton();
        loginPage.clickCreateAccountButton();
        createAccountPage.fillMandatoryCreateAccountForm(validUser);
        Thread.sleep(3000);
    }

    @Test(description = "Tests that user cannot create a new account having empty mandatory fields")
    public void emptyMandatoryFields() {

    }
}
