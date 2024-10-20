package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.URL;
import testdata.User;
import utilities.helpers.SeleniumHelper;
import utilities.helpers.WaitsHelper;

import static utilities.helpers.SeleniumHelper.*;

public class LoginPage {

    WebDriver driver;
    WaitsHelper wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitsHelper(driver);
    }

    //____________________LOCATORS____________________//

    private final By pageTitle = By.xpath("//div[@class=\"page-title\"]");
    private final By alreadyRegisteredHeader = By.xpath("//h2[text()=\"Already registered?\"]");
    private final By emailField = By.id("email");
    private final By emailEmptyError = By.id("advice-required-entry-email");
    private final By emailInvalidError = By.id("advice-validate-email-email");
    private final By passwordField = By.id("pass");
    private final By passwordEmptyError = By.id("advice-required-entry-pass");
    private final By credentialsInvalidError = By.xpath("//li[@class=\"error-msg\"]");
    private final By loginButton = By.xpath("//button[@title=\"Login\"]");
    private final By createAnAccountButton = By.xpath("//a[@title=\"Create an Account\"]");
    private final By forgotPasswordLink = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/forgotpassword/\"]");
    private final By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");

    //____________________METHODS____________________//

    //_____EMAIL FIELD_____//

    public String getCurrentUrl() {
        wait.waitUrlToBe(URL.LOGIN_PAGE, 2);
        return SeleniumHelper.getCurrentUrl();
    }

    public void clickCreateAnAccountButton() {
        click(createAnAccountButton);
    }

    public void enterEmail(String string) {
        wait.waitElementToBeVisible(emailField, 2);
        sendText(emailField, string);
    }

    public String getEmailFieldValue() {
        return getAttribute(emailField, "value");
    }

    public String getEmailSyntaxValidationError() {
        return getAttribute(emailField, "validationMessage");
    }

    public void enterPassword(String string) {
        sendText(passwordField, string);
    }

    public String getPasswordFieldValue() {
        return getAttribute(passwordField, "value");
    }

    public void clickLoginButton() {
        scrollToElement(loginButton);
        wait.waitElementToBeClickable(loginButton, 1);
        click(loginButton);
    }

    public void clearPasswordInput() {
        clear(passwordField);
    }

    public void clearEmailInput() {
        clear(emailField);
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
        wait.waitElementToBeVisible(emailEmptyError, 1);
        return isElementDisplayed(emailEmptyError);
    }

    public String getPasswordEmptyError() {
        return getText(passwordEmptyError);
    }

    public boolean isPasswordEmptyErrorDisplayed() {
        wait.waitElementToBeVisible(passwordEmptyError, 1);
        return isElementDisplayed(passwordEmptyError);
    }

    public boolean isCredentialsInvalidErrorDisplayed() {
        return isElementDisplayed(credentialsInvalidError);
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

    public boolean isEmailInputDisplayed() {
        return isElementDisplayed(emailField);
    }

    public boolean isPasswordInputDisplayed() {
        return isElementDisplayed(passwordField);
    }

}
