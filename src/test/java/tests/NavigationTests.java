package tests;

import constants.LoginConst;
import constants.SignUpConst;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class NavigationTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.HOME_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Registration page")
    public void navigateFromHomePageToRegistrationPage() {
        header.clickAccountButton();
        header.clickRegisterButton();

        assertEquals(signUpPage.getPageTitle(), SignUpConst.CREATE_ACCOUNT_PAGE_TITLE);
        assertTrue(signUpPage.isRegisterButtonDisplayed());
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Login page")
    public void navigateFromHomePageToLoginPage() {
        header.clickAccountButton();
        header.clickLoginButton();

        assertEquals(LoginConst.LOGIN_PAGE_TITLE, loginPage.getPageTitle());
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Women page via the Navigation Bar")
    public void navigateFromHomePageToWomenPage() {
        homePage.clickWomenNavBarButton();

        assertTrue(womenPage.isWomenPageBreadcrumbDisplayed(), "Women page breadcrumbs is not displayed.");
    }

}
