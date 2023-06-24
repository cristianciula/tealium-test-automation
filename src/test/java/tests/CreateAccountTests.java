package tests;

import org.testng.annotations.Test;
import testdata.URL;
import testdata.User;
import testdata.UserInfo;

public class CreateAccountTests extends BaseTest {

    public static User validUser = new User("validUser");
    public static UserInfo userInfo = new UserInfo("userInfo");

    @Test
    public void createNewAccount() {
        driver.get(URL.HOME_PAGE);
        header.clickAccountButton();
        header.clickMyAccountButton();
        loginPage.clickCreateAccountButton();
        createAccountPage.fillCreateAccountForm(userInfo.getFirstName(), userInfo.getMiddleName(), userInfo.getLastName());

    }
}
