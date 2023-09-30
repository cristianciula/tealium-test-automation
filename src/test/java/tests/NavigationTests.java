package tests;

import constants.LoginConst;
import constants.MenShirtsConst;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;
import static utils.SeleniumUtils.*;

public class NavigationTests extends BaseTest{

    @Test (description = "Tests that a user can navigate from the Home page to the Registration page")
    public void navigateToRegistrationPage() {

    }

    @Test (description = "Tests that a user can navigate from the Home page to the Login page")
    public void navigateToLoginPage() {
        navigateTo(URL.HOME_PAGE);
        header.clickAccountButton();
        header.clickLoginButton();

        assertEquals(LoginConst.LOGIN_PAGE_TITLE, loginPage.getLoginPageTitle());
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Men Shirts page")
    public void navigateToMenShirts() {
        navigateTo(URL.HOME_PAGE);
        menu.expandMenDropMenu();
        menu.clickMenShirtsDropOption();

        assertEquals(MenShirtsConst.SHIRTS_PAGE_TITLE, menShirtsPage.getShirtsPageTitle());
    }
}
