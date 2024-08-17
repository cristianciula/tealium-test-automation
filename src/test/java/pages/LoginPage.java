package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.URL;
import testdata.User;
import wrappers.SeleniumWrapper;
import wrappers.WaitsWrapper;

import static wrappers.SeleniumWrapper.*;

public class LoginPage {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//

    private final By pageTitle = By.xpath("//div[@class=\"page-title\"]");
    private final By alreadyRegisteredHeader = By.xpath("//h2[text()=\"Already registered?\"]");
    private final By emailInput = By.id("email");
    private final By emailEmptyError = By.id("advice-required-entry-email");
    private final By emailInvalidError = By.id("advice-validate-email-email");
    private final By passwordInput = By.id("pass");
    private final By passwordEmptyError = By.id("advice-required-entry-pass");
    private final By credentialsInvalidError = By.xpath("//li[@class=\"error-msg\"]");
    private final By loginButton = By.xpath("//button[@title=\"Login\"]");
    private final By createAnAccountButton = By.xpath("//a[@title=\"Create an Account\"]");
    private final By forgotPasswordLink = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/forgotpassword/\"]");
    private final By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");

    //____________________METHODS____________________//

    public String getCurrentUrl() {
        waitsWrapper.waitUrlToBe(URL.LOGIN_PAGE, 2);
        return SeleniumWrapper.getCurrentUrl();
    }

    public void clickCreateAnAccountButton() {
        click(createAnAccountButton);
    }

    public void enterEmail(String string) {
        sendText(emailInput, string);
    }

    public void enterPassword(String string) {
        sendText(passwordInput, string);
    }

    public void clickLoginButton() {
        scrollToElement(loginButton);
        waitsWrapper.waitElementToBeClickable(loginButton, 1);
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

    public void clearEmailAndPasswordInputs() {
        clearEmailInput();
        clearPasswordInput();
    }

    public String getEmailInvalidError() {
        return getText(emailInvalidError);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }

    public String getEmailEmptyError() {
        return getText(emailEmptyError);
    }

    public boolean isEmailEmptyErrorDisplayed() {
        waitsWrapper.waitElementToBeVisible(emailEmptyError, 1);
        return isElementDisplayed(emailEmptyError);
    }

    public String getPasswordEmptyError() {
        return getText(passwordEmptyError);
    }

    public boolean isPasswordEmptyErrorDisplayed() {
        waitsWrapper.waitElementToBeVisible(passwordEmptyError, 1);
        return isElementDisplayed(passwordEmptyError);
    }

    public String getCredentialsInvalidError() {
        return getText(credentialsInvalidError);
    }

    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    public void clickRememberMeCheckbox() {
        click(rememberMeCheckbox);
    }

    public String getAlreadyRegisteredHeader() {
        return getText(alreadyRegisteredHeader);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isCredentialsInvalidErrorDisplayed() {
        return isElementDisplayed(credentialsInvalidError);
    }

    public boolean isEmailInputDisplayed() {
        return isElementDisplayed(emailInput);
    }

    public boolean isPasswordInputDisplayed() {
        return isElementDisplayed(passwordInput);
    }

}
