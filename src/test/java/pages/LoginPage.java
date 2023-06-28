package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


    //----------PRIVATE METHODS----------//


    //----------PUBLIC METHODS----------//
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
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
