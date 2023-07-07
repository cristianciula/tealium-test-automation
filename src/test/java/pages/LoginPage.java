package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;
import utils.Waiter;

import static utils.SeleniumWrapper.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------LOCATORS----------//
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

    //----------PRIVATE METHODS----------//
    private void clear(By by) {
        driver.findElement(by).clear();
    }


    //----------PUBLIC METHODS----------//
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password) {
            driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        scrollToElement(driver, loginButton);
        driver.findElement(loginButton).click();
    }
    public void clearPasswordField() {
        clear(passwordInput);
    }
    public void clearEmailField() {
        clear(emailInput);
    }
    public void loginUser(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginButton();
    }
    public boolean loginButtonIsDisplayed() {
        scrollToElement(driver, loginButton);
        return driver.findElement(loginButton).isDisplayed();
    }
    public String getEmailInputError() {
        return driver.findElement(emailInputError).getText();
    }
    public boolean emailInputErrorIsDisplayed() {
        Waiter.waitElementToBeVisible(driver, emailInputError);
        return driver.findElement(emailInputError).isDisplayed();
    }
    public String getPasswordInputError() {
        return driver.findElement(passwordInputError).getText();
    }
    public boolean passwordInputErrorIsDisplayed() {
        Waiter.waitElementToBeVisible(driver, passwordInputError);
        return driver.findElement(passwordInputError).isDisplayed();
    }
    public String getInvalidCredentialsError() {
        return driver.findElement(invalidCredentialsError).getText();
    }
    public void clickForgotPasswordHyperlink() {
        driver.findElement(forgotPasswordHyperlink).click();
    }
    public void clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckbox).click();
    }
    public String getAlreadyRegisteredHeader() {
        return driver.findElement(alreadyRegisteredHeader).getText();
    }
    public String getLoginPageTitle() {
        return driver.findElement(loginPageTitle).getText();
    }
}
