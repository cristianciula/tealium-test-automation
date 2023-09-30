package tests;

import constants.LoginConst;
import constants.MenShirtsConst;
import constants.RegistrationConst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class NavigationTests extends BaseTest{

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();

        driver.get(URL.HOME_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Registration page")
    public void navigateToRegistrationPage() {
        header.clickAccountButton();
        header.clickRegisterButton();

        assertEquals(registrationPage.getPageTitle(), RegistrationConst.CREATE_ACCOUNT_PAGE_TITLE);
        assertTrue(registrationPage.registerButtonIsDisplayed());
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Login page")
    public void navigateToLoginPage() {
        header.clickAccountButton();
        header.clickLoginButton();

        assertEquals(LoginConst.LOGIN_PAGE_TITLE, loginPage.getLoginPageTitle());
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Men Shirts page")
    public void navigateToMenShirts() {
        menu.expandMenDropMenu();
        menu.clickMenShirtsDropOption();

        assertEquals(MenShirtsConst.SHIRTS_PAGE_TITLE, menShirtsPage.getShirtsPageTitle());
    }
}
