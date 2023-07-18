package tests;

import constants.LoginConst;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.assertEquals;

public class NavigationTests extends BaseTest{

    @Test(description = "Tests that a user can navigate to Login page")
    public void navigateToLoginPage() {
        driver.get(URL.HOME_PAGE);
        header.clickAccountButton();
        header.clickLoginButton();

        assertEquals(LoginConst.LOGIN_PAGE_TITLE, loginPage.getLoginPageTitle());
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
    }
}
