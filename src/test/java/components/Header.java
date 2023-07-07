package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Waiter.*;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //--------------------LOCATORS--------------------//
    private By accountButton = By.xpath("//span[@class=\"label\"][text()=\"Account\"]");
    private By cartButton = By.xpath("//span[@class=\"label\"][contains(.,\"Cart\")]");
    private By accountDropMenu = By.xpath("//div[@id=\"header-account\"]");
    private By myAccountButton = By.xpath("//div[@id=\"header-account\"]/descendant::a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/\"]");
    private By checkoutButton = By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Checkout\"]");
    private By registerButton= By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Register\"]");
    private By logOutButton = By.xpath("//a[@title=\"Log Out\"]");
    private By loginButton = By.xpath("//a[@title=\"Log In\"]");

    //--------------------PRIVATE METHODS--------------------//


    //--------------------PUBLIC METHODS--------------------//

    public void clickMyAccountButton() {
        driver.findElement(myAccountButton).click();
    }
    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public boolean logOutButtonIsDisplayed() {
        waitElementToBeVisible(driver, logOutButton);
        return driver.findElement(logOutButton).isDisplayed();
    }
    public boolean loginButtonIsDisplayed() {
        waitElementToBeVisible(driver, loginButton);
        return driver.findElement(loginButton).isDisplayed();
    }
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
    public void logoutUser() {
        driver.findElement(logOutButton).click();
    }

}
