package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.URL;

import static utils.SeleniumUtils.*;
import static utils.WaitUtils.*;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private By accountButton = By.xpath("//span[@class=\"label\"][text()=\"Account\"]");
    private By cartButton = By.xpath("//span[@class=\"label\"][contains(.,\"Cart\")]");
    private By accountDropMenu = By.xpath("//div[@id=\"header-account\"]");
    private By myAccountButton = By.xpath("//div[@id=\"header-account\"]/descendant::a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/\"]");
    private By checkoutButton = By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Checkout\"]");
    private By registerButton= By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Register\"]");
    private By logOutButton = By.xpath("//a[@title=\"Log Out\"]");
    private By loginButton = By.xpath("//a[@title=\"Log In\"]");
    private By welcomeMessage = By.xpath("//p[@class=\"welcome-msg\"]");

    //____________________PRIVATE METHODS____________________//


    //____________________PUBLIC METHODS____________________//

    public void navigateToHomePage() {
        navigateTo(URL.HOME_PAGE);
    }
    public void clickMyAccountButton() {
        click(myAccountButton);
    }
    public void clickCartButton() {
        click(cartButton);
    }
    public void clickLoginButton() {
        click(loginButton);
    }
    public boolean logOutButtonIsDisplayed() {
        waitElementToBeVisible(logOutButton, 2);
        return isElementDisplayed(logOutButton);
    }
    public boolean loginButtonIsDisplayed() {
        waitElementToBeVisible(loginButton, 2);
        return isElementDisplayed(loginButton);
    }
    public void clickAccountButton() {
        click(accountButton);
    }
    public void clickLogoutButton() {
        click(logOutButton);
        waitUrlToBe("https://ecommerce.tealiumdemo.com/", 10);
    }
    public void clickRegisterButton() {
        click(registerButton);
        waitUrlToBe("https://ecommerce.tealiumdemo.com/customer/account/create/", 2);
    }

}
