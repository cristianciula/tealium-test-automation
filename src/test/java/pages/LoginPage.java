package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;

import static utils.SeleniumUtils.*;
import static utils.WaitUtils.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private By loginPageTitle = By.xpath("//div[@class=\"page-title\"]");
    private By alreadyRegisteredHeader = By.xpath("//h2[text()=\"Already registered?\"]");
    private By createAccountButton = By.xpath("//a[@title=\"Create an Account\"]");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("pass");
    private By loginButton = By.xpath("//button[@title=\"Login\"]");
    private By forgotPasswordHyperlink = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/forgotpassword/\"]");
    private By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private By emailInputError = By.id("advice-required-entry-email");
    private By passwordInputError = By.id("advice-required-entry-pass");
    private By invalidCredentialsError = By.xpath("//li[@class=\"error-msg\"]");

    //____________________PRIVATE METHODS____________________//

    //------------------------------------------------------------------------------------------------------------//

    //____________________PUBLIC METHODS____________________//
    public String getCurrentUrl() {
        return getUrl();
    }
    public void clickCreateAccountButton() {
        click(createAccountButton);
    }
    public void enterEmail(String string) {
        sendKeys(emailInput, string);
    }
    public void enterPassword(String string) {
        sendKeys(passwordInput, string);
    }
    public void clickLoginButton() {
        scrollToElement(loginButton);
        waitElementToBeClickable(loginButton, 1);
        click(loginButton);
    }
    public void clearPasswordInput() {
        clear(passwordInput);
    }
    public void clearEmailInput() {
        clear(emailInput);
    }
    public void loginUser(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginButton();
    }
    public boolean loginButtonIsDisplayed() {
        return isElementDisplayed(loginButton);
    }
    public String getEmailInputError() {
        return getText(emailInputError);
    }
    public boolean emailInputErrorIsDisplayed() {
        waitElementToBeVisible(emailInputError, 1);
        return isElementDisplayed(emailInputError);
    }
    public String getPasswordInputError() {
        return getText(passwordInputError);
    }
    public boolean passwordInputErrorIsDisplayed() {
        waitElementToBeVisible(passwordInputError, 1);
        return isElementDisplayed(passwordInputError);
    }
    public String getInvalidCredentialsError() {
        return getText(invalidCredentialsError);
    }
    public void clickForgotPassword() {
        click(forgotPasswordHyperlink);
    }
    public void clickRememberMeCheckbox() {
        click(rememberMeCheckbox);
    }
    public String getAlreadyRegisteredHeader() {
        return getText(alreadyRegisteredHeader);
    }
    public String getLoginPageTitle() {
        return getText(loginPageTitle);
    }
    public boolean invalidCredentialsErrorIsDisplayed() {
        return isElementDisplayed(invalidCredentialsError);
    }
}
