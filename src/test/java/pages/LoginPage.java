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
    private final By createAccountButton = By.xpath("//a[@title=\"Create an Account\"]");
    private final By emailInputField = By.id("email");
    private final By passwordInputField = By.id("pass");
    private final By loginButton = By.xpath("//button[@title=\"Login\"]");
    private final By forgotPasswordHyperlink = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/forgotpassword/\"]");
    private final By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private final By emailEmptyErrorMessage = By.id("advice-required-entry-email");
    private final By emailSyntaxErrorMessage = By.id("advice-validate-email-email");
    private final By passwordEmptyErrorMessage = By.id("advice-required-entry-pass");
    private final By credentialsInvalidErrorMessage = By.xpath("//li[@class=\"error-msg\"]");

    //____________________PRIVATE METHODS____________________//



    //____________________PUBLIC METHODS____________________//
    public String getCurrentUrl() {
        waitsWrapper.waitUrlToBe(URL.LOGIN_PAGE, 2);
        return SeleniumWrapper.getCurrentUrl();
    }
    public void clickCreateAccountButton() {
        click(createAccountButton);
    }
    public void enterEmail(String string) {
        sendKeys(emailInputField, string);
    }
    public void enterPassword(String string) {
        sendKeys(passwordInputField, string);
    }
    public void clickLoginButton() {
        scrollToElement(loginButton);
        waitsWrapper.waitElementToBeClickable(loginButton, 1);
        click(loginButton);
    }
    public void clearPasswordInputField() {
        clear(passwordInputField);
    }
    public void clearEmailField() {
        clear(emailInputField);
    }
    public void loginUser(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginButton();
    }
    public void clearCredentialsInputFields() {
        clearEmailField();
        clearPasswordInputField();
    }
    public boolean loginButtonIsDisplayed() {
        return isElementDisplayed(loginButton);
    }
    public String getEmailEmptyErrorMessage() {
        return getText(emailEmptyErrorMessage);
    }
    public boolean emailEmptyErrorMessageIsDisplayed() {
        waitsWrapper.waitElementToBeVisible(emailEmptyErrorMessage, 1);
        return isElementDisplayed(emailEmptyErrorMessage);
    }
    public String getPasswordEmptyErrorMessage() {
        return getText(passwordEmptyErrorMessage);
    }
    public boolean passwordEmptyErrorIsDisplayed() {
        waitsWrapper.waitElementToBeVisible(passwordEmptyErrorMessage, 1);
        return isElementDisplayed(passwordEmptyErrorMessage);
    }
    public String getCredentialsInvalidErrorMessage() {
        return getText(credentialsInvalidErrorMessage);
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
    public String getPageTitle() {
        return getText(pageTitle);
    }
    public boolean credentialsInvalidErrorMessageIsDisplayed() {
        return isElementDisplayed(credentialsInvalidErrorMessage);
    }
    public boolean emailFieldIsDisplayed() {
        return isElementDisplayed(emailInputField);
    }
    public boolean passwordFieldIsDisplayed() {
        return isElementDisplayed(passwordInputField);
    }
}
